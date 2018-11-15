package com.demo.Producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @EnableDiscoveryClient
 * @EnableEurekaClient
 * 共同点：都是能够让注册中心能够发现，扫描到改服务。
 * 不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
 */
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
public class Producer_App_8001 {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Producer_App_8001.class, args);
	}

}
