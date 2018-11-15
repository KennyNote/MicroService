package com.demo.Consumer;

import com.demo.RibbonRule.SelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICE-PRODUCER",configuration= SelfRule.class)
public class Consumer_App {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Consumer_App.class, args);
    }
}
