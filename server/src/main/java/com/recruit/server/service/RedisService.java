package com.recruit.server.service;

import java.util.List;

/**
 * redis操作Service
 */

public interface RedisService {

    /**
     * 保存属性
     */
    void set(String key, Object value, long time);

    /**
     * 保存属性
     */
    void set(String key, Object value);

    /**
     * 获取属性
     */
    Object get(String key);

    /**
     * 删除属性
     */
    Boolean del(String key);

    /**
     * 批量删除属性
     */
    Long del(List<String> keys);
}
