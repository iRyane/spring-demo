package com.springboot.modules.sys.controller;


import com.springboot.common.utils.Constant;
import com.springboot.modules.sys.entity.UserEntity;
import com.springboot.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @author yan
 * @since 2018-12-12
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends AbstractController{

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param userEntity
     */
    @PostMapping("/save")
    public void save(@RequestBody UserEntity userEntity){
        userService.add(userEntity);
    }

    /**
     * 删除用户
     * @param ids
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Long[] ids){
        userService.deleteBatch(ids);
    }

    /**
     * 分页获取所有用户
     * @param params
     */
    @GetMapping("/list")
    public void list(@RequestParam Map<String, Object> params){
        //只有超级管理员才能查看所有用户
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }
        userService.queryPage(params);
    }

    /**
     * 更新用户
     * @param user
     */
    @PostMapping("/update")
    public void update(@RequestBody UserEntity user){
        userService.update(user);
    }
}
