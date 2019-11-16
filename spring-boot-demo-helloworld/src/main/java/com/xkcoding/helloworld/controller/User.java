package com.xkcoding.helloworld.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String mobile;
}
