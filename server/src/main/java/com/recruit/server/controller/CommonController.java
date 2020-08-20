package com.recruit.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @RequestMapping("/")
    public String helloworld(){
        return "Hello World111";
    }
}
