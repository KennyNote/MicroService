package com.demo.RibbonRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SelfRule {
    @Bean
    public IRule newRule()
    {
        //return new RandomRule();// Ribbon默认是轮询，我自定义为随机
        //return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机
        return new RandomRule_DIY();// 我自定义为每台机器5次
    }
}
