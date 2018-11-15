package com.demo.Consumer.Controller;

import com.demo.API.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller_Consumer {
    private static final String REST_URL_PREFIX = "http://MICROSERVICE-PRODUCER";

    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/consumer/test/discovery/{id}")
    public String testDiscovery(@PathVariable("id") Integer id){
        return this.clientService.testDiscovery(id);

    }
//    @Autowired
//    private RestTemplate restTemplate;
//
//    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
//    @RequestMapping(value = "/consumer/discovery")
//    public Object discovery()
//    {
//        return restTemplate.getForObject(REST_URL_PREFIX + "/discovery", Object.class);
//    }

}
