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
    public void saveOrUpdate(Integer userId, List<Integer> roleIdList) {

        //保存用户与角色的关联关系
        List<UserRoleEntity> list = new ArrayList<>();
        for(Integer roleId : roleIdList){
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setUserId(userId);
            userRoleEntity.setRoleId(roleId);

            list.add(userRoleEntity);
        }

        this.saveOrUpdateBatch(list);
    }

    @Override
    @Transactional
    public int deleteBatch(Integer[] userIds) {
        return baseMapper.deleteBatch(Arrays.asList(userIds));
    }
}
