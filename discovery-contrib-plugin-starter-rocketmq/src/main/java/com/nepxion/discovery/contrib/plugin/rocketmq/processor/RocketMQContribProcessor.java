package com.nepxion.discovery.contrib.plugin.rocketmq.processor;

import org.apache.commons.lang3.StringUtils;

import com.nepxion.discovery.contrib.plugin.processor.ContribProcessor;
import com.nepxion.discovery.contrib.plugin.rocketmq.constant.RocketMQContribConstant;

public class RocketMQContribProcessor implements ContribProcessor {

    private String destination;

    @Override
    public void process(String key, String value) {
        if (!StringUtils.equals(key, RocketMQContribConstant.ROCKET_MQ)) {
            return;
        }

        System.out.println("实现灰度发布切换逻辑 : " + key + "-" + value);
        destination = value;
    }

    public String getDestination() {
        return destination;
    }
}