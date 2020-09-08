package com.recruit.server.service.impl;

import com.recruit.server.dto.AdminDataParam;
import com.recruit.server.exception.RecruitException;
import com.recruit.server.mapper.AdminMapper;
import com.recruit.server.model.Admin;
import com.recruit.server.service.AdminService;
import com.recruit.server.util.ErrCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean register(AdminDataParam request) {
        java.sql.Timestamp tsCurrent = new java.sql.Timestamp(System.currentTimeMillis());
        request.setCreatetime(tsCurrent.toString());

        // 先检查是否已存在用户
        List<Admin> sameAdmin = adminMapper.selectSameAdmin(request);
        if (sameAdmin.size()!=0){
            throw new RecruitException(ErrCode.SameAdmin);
        }
        // 对密码加密
        String encodePwd = passwordEncoder.encode(request.getPassword());
        request.setPassword(encodePwd);
        int flag = adminMapper.register(request);
        if (flag<=0){
            return false;
        }
        return true;
    }
}
