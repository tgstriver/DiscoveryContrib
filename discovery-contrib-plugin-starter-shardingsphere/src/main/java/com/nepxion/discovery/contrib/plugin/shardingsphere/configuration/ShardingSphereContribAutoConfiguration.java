package com.nepxion.discovery.contrib.plugin.shardingsphere.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nepxion.discovery.contrib.plugin.shardingsphere.processor.ShardingSphereContribProcessor;

@Configuration
public class ShardingSphereContribAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ShardingSphereContribProcessor shardingSphereContribProcessor() {
        return new ShardingSphereContribProcessor();
    }
}