package com.springboot.modules.sys.controller;


import com.springboot.common.utils.Constant;
import com.springboot.modules.sys.entity.RoleEntity;
import com.springboot.modules.sys.service.RoleService;
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
    @PostMapping("/save")
    public void save(@RequestBody RoleEntity role){
        roleService.add(role);
    }

    /**
     * 删除角色
     * @param ids
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Long[] ids){
        roleService.deleteBatch(ids);
    }

    /**
     * 分页获取所有角色
     * @param params
     */
    @GetMapping("/list")
    public void list(@RequestParam Map<String, Object> params){
        //只有超级管理员才能查看所有角色
        if(getUserId() != Constant.SUPER_ADMIN){
            params.put("createUserId", getUserId());
        }
        roleService.queryPage(params);
    }

    /**
     * 更新角色
     * @param role
     */
    @PostMapping("/update")
    public void update(@RequestBody RoleEntity role) {
        roleService.update(role);
    }
}
