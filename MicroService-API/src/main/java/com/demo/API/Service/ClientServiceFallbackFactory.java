package com.demo.API.Service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ClientServiceFallbackFactory implements FallbackFactory<ClientService> {

    @Override
    public ClientService create(Throwable throwable) {
        return new ClientService() {
            @Override
            public String testDiscovery(Integer id) {
                return "No Result, Thanks !!!";
            }


        };
    }
}
