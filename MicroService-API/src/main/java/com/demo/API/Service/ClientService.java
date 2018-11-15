package com.demo.API.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "MICROSERVICE-PRODUCER",fallbackFactory=ClientServiceFallbackFactory.class)
public interface ClientService {

    @RequestMapping(value = "/test/discovery/{id}" , method = RequestMethod.GET)
    public String testDiscovery(@PathVariable("id") Integer id);

}
