package com.nepxion.discovery.contrib.plugin.shardingsphere.processor;

import org.apache.commons.lang3.StringUtils;

import com.nepxion.discovery.contrib.plugin.processor.ContribProcessor;
import com.nepxion.discovery.contrib.plugin.shardingsphere.constant.ShardingSphereContribConstant;

public class ShardingSphereContribProcessor implements ContribProcessor {

    @Override
    public void process(String key, String value) {
        if (!StringUtils.equals(key, ShardingSphereContribConstant.SHARDING_SPHERE)) {
            return;
        }

        System.out.println("实现灰度发布切换逻辑 : " + key + "-" + value);
    }
}