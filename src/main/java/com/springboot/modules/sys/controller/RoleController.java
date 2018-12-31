package com.springboot.modules.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.common.annotation.Log;
import com.springboot.common.utils.Constant;
import com.springboot.common.utils.ResponseBo;
import com.springboot.modules.sys.entity.RoleEntity;
import com.springboot.modules.sys.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yan
 * @since 2018-12-17
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController extends AbstractController{

    @Autowired
    private RoleService roleService;

    /**
     * 添加角色
     * @param role
     */
    @Log("添加角色")
    @PostMapping("/save")
    @RequiresPermissions("sys:role:save")
    public ResponseBo save(@RequestBody RoleEntity role){
        roleService.add(role);
        return ResponseBo.ok();
    }

    /**
     * 删除角色
     * @param ids
     */
    @Log("删除角色")
    @PostMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public ResponseBo delete(@RequestBody Long[] ids){
        roleService.deleteBatch(ids);
        return ResponseBo.ok();
    }

    /**
     * 分页获取所有角色
     * @param params
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:role:select")
    public ResponseBo list(@RequestParam Map<String, Object> params){
        //只有超级管理员才能查看所有角色
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }
        Page<RoleEntity> page = roleService.queryPage(params);
        return ResponseBo.ok().put("Data", page);
    }

    /**
     * 修改角色
     * @param role
     */
    @Log("修改角色")
    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    public ResponseBo update(@RequestBody RoleEntity role) {
        roleService.update(role);
        return ResponseBo.ok();
    }
}
