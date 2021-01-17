package com.pmp.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pmp.common.utils.PageUtil;
import com.pmp.model.entity.SysDictEntity;

import java.util.Map;

//数据字典
public interface SysDictService extends IService<SysDictEntity> {

    PageUtil queryPage(Map<String, Object> params);
}

