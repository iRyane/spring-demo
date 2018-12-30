package com.springboot.modules.sys.mapper;

import com.springboot.modules.sys.entity.LogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yan
 * @since 2018-12-30
 */
@Mapper
public interface LogMapper extends BaseMapper<LogEntity> {

}
