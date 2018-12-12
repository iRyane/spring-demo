package com.example.modules.sys.controller;


import com.example.modules.sys.entity.UserEntity;
import com.example.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author yan
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/sys/user-entity")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param userEntity
     */

    public void save(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
    }

    /**
     * 删除用户
     * @param ids
     */
    public void delect(@RequestBody Integer[] ids){
        userService.removeByIds(Arrays.asList(ids));
    }

}
