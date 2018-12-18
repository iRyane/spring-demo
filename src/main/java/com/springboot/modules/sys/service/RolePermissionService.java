package com.springboot.modules.sys.service;

import com.springboot.modules.sys.entity.RolePermissionEntity;
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
public interface RolePermissionService extends IService<RolePermissionEntity> {

    /**
     * 保存或更新用户角色的关联
     * @param roleId
     * @param permId
     */
    void saveOrUpdate(Integer roleId, List<Integer> permId);

    /**
     * 根据角色Id查询权限Id
     * @param roleId
     * @return
     */
    List<Integer> queryPermIds(Integer roleId);
}
