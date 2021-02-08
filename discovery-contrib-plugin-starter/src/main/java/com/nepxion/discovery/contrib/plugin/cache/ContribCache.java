package com.nepxion.discovery.contrib.plugin.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

public class ContribCache {

    private final LoadingCache<String, String> loadingCache;

    public ContribCache() {
        loadingCache = Caffeine.newBuilder()
                .expireAfterWrite(365 * 100, TimeUnit.DAYS)
                .initialCapacity(10)
                .maximumSize(100)
                .recordStats()
                .build(key -> StringUtils.EMPTY);
    }

    public boolean put(String key, String value) {
        loadingCache.put(key, value);
        return Boolean.TRUE;
    }

    public String get(String key) {
        try {
            return loadingCache.get(key);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        }
    }

    public boolean clear(String key) {
        loadingCache.invalidate(key);
        return Boolean.TRUE;
    }
}