package com.nepxion.discovery.contrib.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestImpl {

    @Autowired
    private RocketMQImpl rocketMQImpl;

    @GetMapping(path = "/rest/{value}")
    public String rest(@PathVariable(value = "value") String value) {
        rocketMQImpl.produce();
        return value;
    }
}