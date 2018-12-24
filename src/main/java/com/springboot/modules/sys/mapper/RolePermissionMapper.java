package com.springboot.modules.sys.mapper;

import com.springboot.modules.sys.entity.RolePermissionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yan
 * @since 2018-12-17
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermissionEntity> {

    /**
     * 根据角色ID查询权限ID
     * @param roleId
     * @return
     */
    List<Long> queryPermIds(Long roleId);

    /**
     * 根据角色ID删除角色与权限的关联关系
     * @param roleIds
     * @return
     */
    int deleteBatch(List<Long> roleIds);
}
