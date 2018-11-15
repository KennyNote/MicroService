package com.demo.ProducerHystrix.Service;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl_Producer implements Service_Producer {
    @Override
    public String testDiscovery(Integer id) {
        if (id%2==0) {
            return "Use Producer-8001 successfully";
        }
        else{
            return "8001";
        }
    }
}
