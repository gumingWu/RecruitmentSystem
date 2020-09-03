package com.recruit.server.mapper;

import com.recruit.server.dto.AdminDataParam;
import com.recruit.server.model.Admin;

import java.util.List;

public interface AdminMapper {
    int register(AdminDataParam request);
    List<Admin> selectSameAdmin(AdminDataParam request);
}
