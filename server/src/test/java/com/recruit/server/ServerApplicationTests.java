package com.recruit.server;

import com.recruit.server.util.myStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServerApplicationTests {

    @Test
    void contextLoads() {
        int[] array = {1,2,3,4,5,6};
        String res = myStringUtils.printArray(array);
        System.out.println(res);
    }

}
