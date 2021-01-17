package com.pmp.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pmp.common.utils.PageUtil;
import com.pmp.model.entity.SysLogEntity;

import java.util.Map;

/**
 * Created by Administrator on 2019/8/5.
 */
public interface SysLogService extends IService<SysLogEntity>{

    PageUtil queryPage(Map<String, Object> params);

    void truncate();

}
