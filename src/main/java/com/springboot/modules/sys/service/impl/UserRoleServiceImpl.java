package com.springboot.modules.sys.service.impl;

import com.springboot.modules.sys.entity.UserRoleEntity;
import com.springboot.modules.sys.mapper.UserRoleMapper;
import com.springboot.modules.sys.service.UserRoleService;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements UserRoleService {

    @Override
    @Transactional
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        //先删除用户与角色的关联关系
        deleteBatch(new Long[]{userId});

        //保存用户与角色的关联关系
        List<UserRoleEntity> list = new ArrayList<>();
        for(Long roleId : roleIdList){
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setUserId(userId);
            userRoleEntity.setRoleId(roleId);

            list.add(userRoleEntity);
        }

        this.saveOrUpdateBatch(list);
    }

    @Override
    @Transactional
    public void deleteBatch(Long[] userIds) {
        baseMapper.deleteBatch(Arrays.asList(userIds));
    }
}
