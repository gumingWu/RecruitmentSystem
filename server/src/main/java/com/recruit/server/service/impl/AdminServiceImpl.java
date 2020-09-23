package com.recruit.server.service.impl;

import com.recruit.server.dto.AdminDataParam;
import com.recruit.server.exception.RecruitException;
import com.recruit.server.mapper.AdminMapper;
import com.recruit.server.model.Admin;
import com.recruit.server.service.AdminCacheService;
import com.recruit.server.service.AdminService;
import com.recruit.server.util.ErrCode;
import com.recruit.server.util.JwtUtils;
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

    @Autowired
    private AdminCacheService adminCacheService;

    @Autowired
    private JwtUtils jwtUtils;

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

    @Override
    public String login(AdminDataParam request) {
        String token = null;
        try {
            Admin admin = getAdminByTelOrEmail(request);
            if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())){
                throw new RecruitException(ErrCode.ErrorPassWord);
            }
            token = jwtUtils.generateTokenByAdmin(admin);
            return token;
        } catch (Exception e){
            throw new RecruitException(ErrCode.ERROR.getErrCode(), e.getMessage());
        }
    }

    private Admin getAdminByTelOrEmail(AdminDataParam request){
        Admin admin = null;
        admin = adminCacheService.getRedisAdmin(request.getTelephone(), request.getEmail());
        if (admin != null){
            return admin;
        }
        admin = adminMapper.selectSameAdmin(request).get(0);
        if (admin != null){
            adminCacheService.setRedisAdmin(admin);
        }
        return admin;
    }
}
