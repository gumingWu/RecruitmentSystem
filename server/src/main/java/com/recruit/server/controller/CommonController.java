package com.recruit.server.controller;

import com.recruit.server.service.service_test.ser_test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @Autowired
    private ser_test service;

    @RequestMapping("/")
    public String helloworld(){
        return "Hello World111";
    }

    @RequestMapping("/select")
    public String select(){
        service.service_test();
        return "success";
    }
}
