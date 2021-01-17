package com.pmp.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pmp.model.entity.SysMenuEntity;
import com.pmp.model.entity.SysUserEntity;

import java.util.List;


public interface SysMenuService extends IService<SysMenuEntity>{

    List<SysMenuEntity> queryAll();

    List<SysMenuEntity> queryNotButtonList();

    List<SysMenuEntity> queryByParentId(Long menuId);

    void delete(Long menuId);

    List<SysMenuEntity> getUserMenuList(Long currUserId);
}
