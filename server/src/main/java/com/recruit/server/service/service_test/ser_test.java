package com.recruit.server.service.service_test;

import com.recruit.server.mapper.mapper_test;
import com.recruit.server.model.model_test.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ser_test {
    @Autowired
    private mapper_test mapper;

    public void service_test(){
        try {
            List<test> list = mapper.selectall();
            for (test i: list){

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
