package com.pmp.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pmp.model.entity.SysUserRoleEntity;

import java.util.List;


public interface SysUserRoleService extends IService<SysUserRoleEntity>{

    void deleteBatch(List<Long> roleIds);

    void saveOrUpdate(Long userId, List<Long> roleIds);

    List<Long> queryRoleIdList(Long userId);
}
