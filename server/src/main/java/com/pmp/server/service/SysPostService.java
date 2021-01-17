package com.pmp.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pmp.common.utils.PageUtil;
import com.pmp.model.entity.SysPostEntity;

import java.util.Map;

/**
 * @Author gali
 * @Description //TODO
 * @Date 22:16 2021/1/16
 **/
public interface SysPostService extends IService<SysPostEntity>{

    PageUtil queryPage(Map<String,Object> params);

    void savePost(SysPostEntity entity);

    void updatePost(SysPostEntity entity);

    void deletePatch(Long[] ids);
}
