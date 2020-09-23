package com.recruit.server.service;

import com.recruit.server.dto.AdminDataParam;

public interface AdminService {
    /**
     * 用户注册
     * @return
     */
    public boolean register(AdminDataParam request);

    /**
     * 用户登录
     */
    public String login(AdminDataParam request);
}
