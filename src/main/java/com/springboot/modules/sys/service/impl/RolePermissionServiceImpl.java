package com.springboot.modules.sys.service.impl;

import com.springboot.modules.sys.entity.RolePermissionEntity;
import com.springboot.modules.sys.mapper.RolePermissionMapper;
import com.springboot.modules.sys.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yan
 * @since 2018-12-17
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermissionEntity> implements RolePermissionService {

    @Override
    @Transactional
    public void saveOrUpdate(Long roleId, List<Long> permIdList) {
        //先删除角色与权限的关联关系
        deleteBatch(new Long[]{roleId});

        if(permIdList.size() == 0){
            return;
        }

        //保存角色与菜单的关联
        List<RolePermissionEntity> list = new ArrayList<>(permIdList.size());
        for(Long permId : permIdList){
            RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
            rolePermissionEntity.setRoleId(roleId);
            rolePermissionEntity.setPermissionId(permId);

            list.add(rolePermissionEntity);
        }

        this.saveOrUpdateBatch(list);
    }

    @Override
    public List<Long> queryPermIds(Long roleId) {
        return baseMapper.queryPermIds(roleId);
    }

    @Override
    @Transactional
    public int deleteBatch(Long[] roleIds) {
        return baseMapper.deleteBatch(Arrays.asList(roleIds));
    }
}
