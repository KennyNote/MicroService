package com.demo.Producer.Controller;

import com.demo.Producer.Service.Service_Producer;
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
    public String testDiscovery(@PathVariable("id") Integer id){
        String string = service_producer.testDiscovery(id);
        if (string == "8002"){
            throw new RuntimeException("8002");
        }
        return string;

    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        System.out.println("MicroService-8002");
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
