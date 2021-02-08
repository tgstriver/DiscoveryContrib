package com.nepxion.discovery.contrib.plugin.rocketmq.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nepxion.discovery.contrib.plugin.rocketmq.processor.RocketMQContribProcessor;

@Configuration
public class RocketMQContribAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public RocketMQContribProcessor rocketMQContribProcessor() {
        return new RocketMQContribProcessor();
    }
}