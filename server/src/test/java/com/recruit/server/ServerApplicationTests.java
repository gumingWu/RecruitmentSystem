package com.recruit.server;

import com.recruit.server.model.Study.Person;
import com.recruit.server.service.RedisService;
import com.recruit.server.service.impl.RedisServiceImpl;
import com.recruit.server.util.myStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
class ServerApplicationTests {
    @Autowired
    private Person person;

    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
        int[] array = {1,2,3,4,5,6};
        String res = myStringUtils.printArray(array);
        System.out.println(res);
    }

    @Test
    void secondTest(){
        System.out.println(person.toString());
        String key = "testkey2";
        String value = "testvalue2";
        redisService.set(key, value);
    }

}
