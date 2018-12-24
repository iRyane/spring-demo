package com.springboot.modules.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.modules.sys.entity.RoleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yan
 * @since 2018-12-17
 */
public interface RoleService extends IService<RoleEntity> {

    /**
     * 分页查询角色信息
     * @param params
     * @return
     */
    Page<RoleEntity> queryPage(Map<String, Object> params);

    /**
     * 添加角色
     * @param roleEntity
     */
    void add(RoleEntity roleEntity);

    /**
     * 更新角色
     * @param roleEntity
     */
    void update(RoleEntity roleEntity);

    /**
     * 删除角色
     * @param roleIds
     * @return
     */
    int deleteBatch(Long[] roleIds);
}
