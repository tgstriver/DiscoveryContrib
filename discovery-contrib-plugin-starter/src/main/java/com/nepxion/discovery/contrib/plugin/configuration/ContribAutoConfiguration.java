package com.nepxion.discovery.contrib.plugin.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nepxion.discovery.contrib.plugin.cache.ContribCache;
import com.nepxion.discovery.contrib.plugin.matcher.ContribMatcher;
import com.nepxion.discovery.contrib.plugin.subscriber.ContribSubscriber;

@Configuration
public class ContribAutoConfiguration {

    @Bean
    public ContribCache contribCache() {
        return new ContribCache();
    }

    @Bean
    @ConditionalOnMissingBean
    public ContribSubscriber contribSubscriber() {
        return new ContribSubscriber();
    }

    @Bean
    @ConditionalOnMissingBean
    public ContribMatcher contribMatcher() {
        return new ContribMatcher();
    }
}