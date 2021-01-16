package com.pmp.server.service.impl;/**
 * Created by Administrator on 2019/8/1.
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.debug.pmp.common.response.StatusCode;
import com.debug.pmp.common.utils.CommonUtil;
import com.debug.pmp.common.utils.PageUtil;
import com.debug.pmp.common.utils.QueryUtil;
import com.debug.pmp.model.entity.SysPostEntity;
import com.debug.pmp.model.mapper.SysPostDao;
import com.debug.pmp.server.service.SysPostService;
import com.google.common.base.Joiner;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/8/1 10:05
 **/
@Service("sysPostService")
public class SysPostServiceImpl extends ServiceImpl<SysPostDao,SysPostEntity> implements SysPostService{

    private static final Logger log= LoggerFactory.getLogger(SysPostServiceImpl.class);

    //分页模糊查询
    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        String search= (params.get("search") == null)? "": params.get("search").toString() ;

        //调用自封装的分页查询工具
        IPage<SysPostEntity> queryPage=new QueryUtil<SysPostEntity>().getQueryPage(params);

        QueryWrapper wrapper=new QueryWrapper<SysPostEntity>()
                .like(StringUtils.isNotBlank(search),"post_code",search.trim())
                .or(StringUtils.isNotBlank(search))
                .like(StringUtils.isNotBlank(search),"post_name",search.trim());

        IPage<SysPostEntity> resPage=this.page(queryPage,wrapper);
        return new PageUtil(resPage);
    }

    //新增
    @Override
    public void savePost(SysPostEntity entity) {
        if (this.getOne(new QueryWrapper<SysPostEntity>().eq("post_code",entity.getPostCode()))!=null){
            throw new RuntimeException(StatusCode.PostCodeHasExist.getMsg());
        }
        entity.setCreateTime(DateTime.now().toDate());
        save(entity);
    }

    //修改
    @Override
    public void updatePost(SysPostEntity entity) {
        SysPostEntity old=this.getById(entity.getPostId());
        if (old!=null && !old.getPostCode().equals(entity.getPostCode())){
            if (this.getOne(new QueryWrapper<SysPostEntity>().eq("post_code",entity.getPostCode()))!=null){
                throw new RuntimeException(StatusCode.PostCodeHasExist.getMsg());
            }
        }

        entity.setUpdateTime(DateTime.now().toDate());
        updateById(entity);
    }

    //批量删除
    @Override
    public void deletePatch(Long[] ids) {
        //第一种写法 - mybatis-plus
        //removeByIds(Arrays.asList(ids));

        //第二种写法
        //ids=[1,2,3,4,5];  ->  "1,2,3,4,5"
        String delIds=Joiner.on(",").join(ids);
        baseMapper.deleteBatch(CommonUtil.concatStrToInt(delIds,","));
    }
}




























