package com.springboot.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.modules.sys.entity.RoleEntity;
import com.springboot.modules.sys.mapper.RoleMapper;
import com.springboot.modules.sys.service.RolePermissionService;
import com.springboot.modules.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                new QueryWrapper<RoleEntity>()
                        .eq(createUserId != null, "create_user_id", createUserId)
        );
        return page;
    }

    @Override
    @Transactional
    public void add(RoleEntity roleEntity){
        //添加角色
        this.save(roleEntity);

        //保存角色与菜单的关联关系
        rolePermissionService.saveOrUpdate(roleEntity.getId(), roleEntity.getPermissionIdList() );
    }

    @Override
    @Transactional
    public void update(RoleEntity roleEntity) {
        this.updateById(roleEntity);

        //更新角色与菜单的关联关系
        rolePermissionService.saveOrUpdate(roleEntity.getId(), roleEntity.getPermissionIdList() );
    }

    @Override
    @Transactional
    public int deleteBatch(Long[] roleIds) {
        this.removeByIds(Arrays.asList(roleIds));

        //删除角色与权限的关联关系
        return rolePermissionService.deleteBatch(roleIds);
    }
}
