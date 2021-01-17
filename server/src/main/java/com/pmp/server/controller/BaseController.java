package com.pmp.server.controller;

import com.pmp.model.entity.SysUserEntity;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gali
 * @description 基类
 * @date 2021/01/16 14:24
 **/
public abstract class BaseController {
    //统一日志
    protected Logger log= LoggerFactory.getLogger(getClass());

    public SysUserEntity getUser(){
        SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        return user;
    }
    protected Long getUserId(){
        return getUser().getUserId();
    }

    protected String getUserName(){
        return getUser().getUsername();
    }

    protected Long getDeptId(){
        return getUser().getDeptId();
    }
}
