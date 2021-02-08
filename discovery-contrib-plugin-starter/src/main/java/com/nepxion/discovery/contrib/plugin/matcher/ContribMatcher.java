package com.nepxion.discovery.contrib.plugin.matcher;

import com.nepxion.discovery.common.util.StringUtil;
import com.nepxion.discovery.plugin.framework.adapter.PluginAdapter;
import com.nepxion.discovery.plugin.strategy.matcher.DiscoveryMatcherStrategy;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContribMatcher {

    @Autowired
    protected DiscoveryMatcherStrategy discoveryMatcherStrategy;

    @Autowired
    protected PluginAdapter pluginAdapter;

    public boolean match(String targetValues, String value) {
        // 如果精确匹配不满足，尝试用通配符匹配
        List<String> targetValueList = StringUtil.splitToList(targetValues);
        if (CollectionUtils.isEmpty(targetValueList)) {
            return false;
        }

        if (targetValueList.contains(value)) {
            return true;
        }

        // 通配符匹配。前者是通配表达式，后者是具体值
        for (String targetValuePattern : targetValueList) {
            if (discoveryMatcherStrategy.match(targetValuePattern, value)) {
                return true;
            }
        }

        return false;
    }

    public boolean matchAddress(String addresses) {
        // 如果精确匹配不满足，尝试用通配符匹配
        List<String> addressList = StringUtil.splitToList(addresses);
        if (CollectionUtils.isEmpty(addressList)) {
            return false;
        }

        if (addressList.contains(pluginAdapter.getHost() + ":" + pluginAdapter.getPort())
                || addressList.contains(pluginAdapter.getHost())
                || addressList.contains(String.valueOf(pluginAdapter.getPort()))) {
            return true;
        }

        // 通配符匹配。前者是通配表达式，后者是具体值
        for (String addressPattern : addressList) {
            if (discoveryMatcherStrategy.match(addressPattern, pluginAdapter.getHost() + ":" + pluginAdapter.getPort())
                    || discoveryMatcherStrategy.match(addressPattern, pluginAdapter.getHost())
                    || discoveryMatcherStrategy.match(addressPattern, String.valueOf(pluginAdapter.getPort()))) {
                return true;
            }
        }

        return false;
    }
}