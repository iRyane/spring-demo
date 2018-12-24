package com.springboot.modules.sys.mapper;

import com.springboot.modules.sys.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yan
 * @since 2018-12-12
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 查询用户的所有权限
     * @param userId
     * @return
     */
    List<String> queryPerms(Long userId);

    /**
     * 查询用户的所有权限ID
     * @param userId
     * @return
     */
    List<Long> queryPermIds(Long userId);

}
