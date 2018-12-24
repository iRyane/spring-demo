package com.springboot.modules.sys.mapper;

import com.springboot.modules.sys.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yan
 * @since 2018-12-17
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {

    int addRole(RoleEntity role);
}
