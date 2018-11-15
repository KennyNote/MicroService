package com.demo.ProducerHystrix.Controller;

import com.demo.ProducerHystrix.Service.Service_Producer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@RestController
public class Controller_Producer {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private Service_Producer service_producer;

    @RequestMapping(value = "/test/discovery/{id}" , method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "messagesProcessHystrix")
    public String testDiscovery(@PathVariable("id") Integer id){
        String string = service_producer.testDiscovery(id);
        if (string == "8001"){
            throw new RuntimeException("8001");
        }
        return string;

    }
    public String messagesProcessHystrix(@PathVariable("id") Integer id){
        return "No Result, Thanks !!!";
    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        System.out.println("MicroServiceHystrix-8001");
        List<String> list = client.getServices();
        System.out.println(list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICE-PRODUCER");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
