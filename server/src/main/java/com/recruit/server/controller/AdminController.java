package com.recruit.server.controller;

import com.recruit.server.dto.AdminDataParam;
import com.recruit.server.exception.RecruitException;
import com.recruit.server.service.AdminService;
import com.recruit.server.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public JsonResponse register(@RequestBody AdminDataParam request) throws RecruitException  {

            boolean flag = adminService.register(request);
            if (!flag){
                return JsonResponse.error();
            }
            return JsonResponse.success();

    }
}
