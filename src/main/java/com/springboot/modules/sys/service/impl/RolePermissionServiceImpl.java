package com.springboot.modules.sys.service.impl;

import com.springboot.modules.sys.entity.RolePermissionEntity;
import com.springboot.modules.sys.mapper.RolePermissionMapper;
import com.springboot.modules.sys.service.RolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void saveOrUpdate(Integer roleId, List<Integer> permIdList) {
        //先删除用户与角色的关联
        baseMapper.deleteBatchIds(Arrays.asList(roleId));

        if(permIdList.size() == 0){
            return;
        }

        //保存角色与菜单的关联
        List<RolePermissionEntity> list = new ArrayList<>(permIdList.size());
        for(Integer permId : permIdList){

            RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
            rolePermissionEntity.setRoleId(roleId);
            rolePermissionEntity.setPermissionId(permId);

            list.add(rolePermissionEntity);
        }

        this.saveBatch(list);
    }

    @Override
    public List<Integer> queryPermIds(Integer roleId) {
        return baseMapper.queryPermIds(roleId);
    }
}
