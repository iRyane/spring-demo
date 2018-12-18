package com.springboot.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.modules.sys.entity.RoleEntity;
import com.springboot.modules.sys.mapper.RoleMapper;
import com.springboot.modules.sys.service.RolePermissionService;
import com.springboot.modules.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yan
 * @since 2018-12-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Autowired private RolePermissionService rolePermissionService;
    @Override
    public Page<RoleEntity> queryPage(Map<String, Object> params) {
        Long curr = (Long)params.get("current");
        Long size = (Long)params.get("size");
        Long createUserId = (Long)params.get("createUserId");

        Page<RoleEntity> page = (Page<RoleEntity>) this.page(
                new Page<>(curr,size),
                new EmptyWrapper<RoleEntity>()
                        .eq(createUserId != null, "create_user_id", createUserId)
        );
        return page;
    }

    @Override
    public void add(RoleEntity roleEntity){
        //添加角色
        this.save(roleEntity);

        //保存角色与菜单的关系
        rolePermissionService.saveOrUpdate(roleEntity.getId(), roleEntity.getPermissionIdList() );
    }

    @Override
    public void update(RoleEntity roleEntity) {
        this.updateById(roleEntity);

        //更新角色与菜单的关系
        rolePermissionService.saveOrUpdate(roleEntity.getId(), roleEntity.getPermissionIdList() );
    }

    @Override
    public void deleteBatch(Integer[] roleIds) {
        this.removeByIds(Arrays.asList(roleIds));

        rolePermissionService.removeByIds(Arrays.asList(roleIds));
    }
}
