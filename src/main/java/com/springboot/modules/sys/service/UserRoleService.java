package com.springboot.modules.sys.service;

import com.springboot.modules.sys.entity.UserRoleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yan
 * @since 2018-12-17
 */
public interface UserRoleService extends IService<UserRoleEntity> {

    /**
     * 添加或更新用户与角色的关联关系
     * @param userId
     * @param roleId
     */
    void saveOrUpdate(Long userId, List<Long> roleId);

    /**
     * 删除用户与角色的关联关系
     * @param userIds
     */
    void deleteBatch(Long[] userIds);
}
