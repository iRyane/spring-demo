package com.springboot.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.modules.sys.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;
import java.util.Set;

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

    /**
     * 添加用户
     * @param user
     */
    void add(UserEntity user);

    /**
     * 更新用户
     * @param user
     */
    void update(UserEntity user);

    /**
     * 删除用户
     * @param userIds
     */
    void deleteBatch(Integer[] userIds);

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    Set<String> queryPerms(Integer userId);
}
