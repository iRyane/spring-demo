package com.springboot.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.modules.sys.entity.UserEntity;
import com.springboot.modules.sys.mapper.UserMapper;
import com.springboot.modules.sys.service.UserRoleService;
import com.springboot.modules.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author yan
 * @since 2018-12-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired private UserRoleService userRoleService;

    @Override
    public Page<UserEntity> queryPage(Map<String, Object> params) {
        Long curr = (Long)params.get("current");
        Long size = (Long)params.get("size");
        Integer createUserId = (Integer) params.get("createUserId");

        Page<UserEntity> page = (Page<UserEntity>) this.page(
                new Page<>(curr,size),
                new QueryWrapper<UserEntity>()
                        .eq(createUserId != null, "create_user_id", createUserId)
        );
        return page;
    }

    @Override
    public void add(UserEntity user) {
        this.save(user);

        //保存用户与角色的关联关系
        userRoleService.saveOrUpdate(user.getId(), user.getRoleIdList());
    }

    @Override
    public void update(UserEntity user) {
        this.updateById(user);

        //更新用户与角色的关联关系
        userRoleService.saveOrUpdate(user.getId(), user.getRoleIdList());
    }

    @Override
    public void deleteBatch(Long[] userIds) {
        this.removeByIds(Arrays.asList(userIds));

        //删除用户与角色的关联关系
        userRoleService.deleteBatch(userIds);
    }

    @Override
    public Set<String> queryPerms(Long userId) {
        List<String> permsList =baseMapper.queryPerms(userId);
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }
}
