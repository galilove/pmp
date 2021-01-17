package com.pmp.model.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pmp.model.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gali
 * 系统日志信息
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {

    void truncate();

}
