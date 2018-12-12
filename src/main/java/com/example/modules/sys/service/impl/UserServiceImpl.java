package com.example.modules.sys.service.impl;

import com.example.modules.sys.entity.UserEntity;
import com.example.modules.sys.mapper.UserMapper;
import com.example.modules.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author yan
 * @since 2018-12-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
