package com.springboot.modules.sys.service.impl;

import com.springboot.modules.sys.entity.LogEntity;
import com.springboot.modules.sys.mapper.LogMapper;
import com.springboot.modules.sys.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yan
 * @since 2018-12-30
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogEntity> implements LogService {

}
