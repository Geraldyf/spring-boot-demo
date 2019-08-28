package com.xkcoding.helloworld.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {

    @Autowired
    private TestService testService;


    @Before
    public void before(){
        System.out.println("开始测试...");
    }


    @After
    public void after(){
        System.out.println("测试结束...");
    }

    @Test
    public void printStr() {
        testService.printStr("xiaohua");
    }
}
