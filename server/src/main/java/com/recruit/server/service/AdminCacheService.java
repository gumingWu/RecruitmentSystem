package com.recruit.server.service;

import com.recruit.server.model.Admin;

public interface AdminCacheService {

    /**
     * 从redis中获取用户信息
     */
    public Admin getRedisAdmin(String tel, String email);

    /**
     * 将用户信息存入redis
     */
    public void setRedisAdmin(Admin admin);
}
