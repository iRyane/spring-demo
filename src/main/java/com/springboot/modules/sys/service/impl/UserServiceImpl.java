package com.springboot.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.modules.sys.entity.UserEntity;
import com.springboot.modules.sys.mapper.UserMapper;
import com.springboot.modules.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yan
 * @since 2018-12-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public Page<UserEntity> queryPage(Map<String, Object> params) {
        Long curr = (Long)params.get("current");
        Long size = (Long)params.get("size");
        Long createUserId = (Long)params.get("createUserId");

        Page<UserEntity> page = (Page<UserEntity>) this.page(
                new Page<>(curr,size),
                new EmptyWrapper<UserEntity>()
                        .eq(createUserId != null, "name", createUserId)
        );
        return page;
    }
}
