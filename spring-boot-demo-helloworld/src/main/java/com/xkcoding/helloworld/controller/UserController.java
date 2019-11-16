package com.xkcoding.helloworld.controller;


import org.springframework.web.bind.annotation.*;

/**
 * 用户操作接口
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    /**
     * 创建
     *
     * @param user
     * @return
     */
    @PostMapping
    public User create(User user) {
        return user;
    }

    /**
     * 查询
     *
     * @param name 用户名
     * @return
     */
    @GetMapping
    public User getName(String name) {
        return new User();
    }

    /**
     * 修改
     *
     * @param name
     * @return
     */
    @PutMapping
    public String update(String name) {
        return name;
    }

    /**
     * 删除
     *
     * @param name
     * @return
     */
    @DeleteMapping
    public String delete(String name) {
        return name;
    }

}
