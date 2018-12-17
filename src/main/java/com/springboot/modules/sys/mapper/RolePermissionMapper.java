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

    List<Integer> queryPermIds(Integer roleId);
}
