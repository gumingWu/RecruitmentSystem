package com.recruit.server.service.impl;

import com.recruit.server.dto.AdminDataParam;
import com.recruit.server.model.Admin;
import com.recruit.server.service.AdminCacheService;
import com.recruit.server.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminCacheServiceImpl implements AdminCacheService {
    @Autowired
    private RedisService redisService;

    @Override
    public Admin getRedisAdmin(String tel, String email) {
        String key = "TEL:"+tel+"EMAIL"+email;
        return (Admin) redisService.get(key);
    }

    @Override
    public void setRedisAdmin(Admin admin) {
        String key = "TEL:"+admin.getTelephone()+"EMAIL"+admin.getEmail();
        redisService.set(key, admin);
    }
}
