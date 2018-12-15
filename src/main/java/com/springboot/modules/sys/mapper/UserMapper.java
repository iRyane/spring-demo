package com.springboot.modules.sys.mapper;

import com.springboot.modules.sys.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
