package com.xkcoding.helloworld.service.impl;

import com.xkcoding.helloworld.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void printStr(String str) {
        System.out.println("hello," + str);
    }
}
