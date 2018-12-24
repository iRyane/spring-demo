package com.springboot.modules.sys.controller;

import com.springboot.modules.sys.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author :yan
 * @Date :Create in 12/14/18
 * @Description :Controller公共组件
 */

public abstract class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected UserEntity getUser(){
        return (UserEntity)SecurityUtils.getSubject().getPrincipals();
    }

    protected Long getUserId(){
        return getUser().getId();
    }
}


