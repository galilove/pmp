package com.pmp.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pmp.common.utils.PageUtil;
import com.pmp.model.entity.SysUserEntity;

import java.util.Map;

/**
 * Created by Administrator on 2019/7/31.
 */
public interface SysUserService extends IService<SysUserEntity>{

    /**
     * @Author gali
     * @Description //修改密码
     * @Date 22:06 2021/1/16
     * @Param [userId, oldPassword, newPassword]
     * @return boolean
     **/
    boolean updatePassword(Long userId,String oldPassword,String newPassword);
    /**
     * @Author gali
     * @Description //分页查询信息
     * @Date 22:06 2021/1/16
     * @Param [map]
     * @return com.pmp.common.utils.PageUtil
     **/
    PageUtil queryPage(Map<String,Object> map);
    /**
     * @Author gali
     * @Description //TODO 保存用户信息
     * @Date 22:06 2021/1/16
     * @Param [entity]
     * @return void
     **/
    void saveUser(SysUserEntity entity);
    /**
     * @Author gali
     * @Description //获取用户信息
     * @Date 22:06 2021/1/16
     * @Param [userId]
     * @return com.pmp.model.entity.SysUserEntity
     **/
    SysUserEntity getInfo(Long userId);
    /**
     * @Author gali
     * @Description //更新用户信息
     * @Date 22:06 2021/1/16
     * @Param [entity]
     * @return void
     **/
    void updateUser(SysUserEntity entity);
    /**
     * @Author gali
     * @Description //删除用户信息
     * @Date 22:07 2021/1/16
     * @Param [ids]
     * @return void
     **/
    void deleteUser(Long[] ids);
    /**
     * @Author gali
     * @Description //跟个id 批量删除用户信息
     * @Date 22:07 2021/1/16
     * @Param [ids]
     * @return void
     **/
    void updatePsd(Long[] ids);
}
































