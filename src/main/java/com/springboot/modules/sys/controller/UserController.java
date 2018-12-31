package com.springboot.modules.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.common.annotation.Log;
import com.springboot.common.utils.Constant;
import com.springboot.common.utils.ResponseBo;
import com.springboot.modules.sys.entity.UserEntity;
import com.springboot.modules.sys.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Log("添加用户")
    @PostMapping("/save")
    @RequiresPermissions("sys:user:save")
    public ResponseBo save(@RequestBody UserEntity userEntity){
        userService.add(userEntity);
        return ResponseBo.ok();
    }

    /**
     * 删除用户
     * @param ids
     */
    @Log("删除用户")
    @PostMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public ResponseBo delete(@RequestBody Long[] ids){
        userService.deleteBatch(ids);
        return ResponseBo.ok();
    }

    /**
     * 分页获取所有用户
     * @param params
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:user:select")
    public ResponseBo list(@RequestParam Map<String, Object> params){
        //只有超级管理员才能查看所有用户
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }
        Page<UserEntity> page = userService.queryPage(params);
        return ResponseBo.ok().put("Data", page);

    }

    /**
     * 修改用户
     * @param user
     */
    @Log("修改用户")
    @PostMapping("/update")
    @RequiresPermissions("sys:user:update")
    public ResponseBo update(@RequestBody UserEntity user){
        userService.update(user);
        return ResponseBo.ok();
    }
}
