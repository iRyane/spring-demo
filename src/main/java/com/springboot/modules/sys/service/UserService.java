package com.springboot.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.modules.sys.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author yan
 * @since 2018-12-12
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 分页查询用户信息
     * @param params
     * @return
     */
    Page<UserEntity> queryPage(Map<String, Object> params);
}
