package com.springboot.modules.sys.mapper;

import com.springboot.modules.sys.entity.UserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
public interface UserRoleMapper extends BaseMapper<UserRoleEntity> {

    int deleteBatch(List<Long> userIds);

    List<String> queryRoles(Long userId);
}
