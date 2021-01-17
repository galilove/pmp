package com.pmp.common.utils;/**
 * Created by Administrator on 2019/7/18.
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pmp.common.filter.SQLFilter;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @Author gali
 * @Description //查询统一封装的工具类
 * @Date 22:13 2021/1/16
 **/
public class QueryUtil<T> {

    /**
     * 根据前端传递过来的参数进行转换 - 过滤
     * @param params
     * @return
     */
    public IPage<T> getPage(Map<String, Object> params) {
        return this.getPage(params, null, false);
    }

    public IPage<T> getPage(Map<String, Object> params, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = 1;
        long limit = 10;

        if(params.get(com.pmp.common.utils.Constant.PAGE) != null){
            curPage = Long.parseLong((String)params.get(com.pmp.common.utils.Constant.PAGE));
        }
        if(params.get(com.pmp.common.utils.Constant.LIMIT) != null){
            limit = Long.parseLong((String)params.get(com.pmp.common.utils.Constant.LIMIT));
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //分页参数
        params.put(com.pmp.common.utils.Constant.PAGE, page);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject((String)params.get(com.pmp.common.utils.Constant.ORDER_FIELD));
        String order = (String)params.get(com.pmp.common.utils.Constant.ORDER);

        //前端字段排序
        if(StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)){
            if(com.pmp.common.utils.Constant.ASC.equalsIgnoreCase(order)) {
                return page.setAsc(orderField);
            }else {
                return page.setDesc(orderField);
            }
        }

        //默认排序
        if(isAsc) {
            page.setAsc(defaultOrderField);
        }else {
            page.setDesc(defaultOrderField);
        }

        return page;
    }

    //重载的查询
    public IPage<T> getQueryPage(Map<String, Object> params) {
        //当前第几页、每页显示的条目
        long curPage = 1;
        long limit = 10;

        if (params.get(com.pmp.common.utils.Constant.PAGE)!=null){
            curPage=Long.valueOf(params.get(com.pmp.common.utils.Constant.PAGE).toString());
        }
        if (params.get(com.pmp.common.utils.Constant.LIMIT)!=null){
            limit=Long.valueOf(params.get(com.pmp.common.utils.Constant.LIMIT).toString());
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //前端请求的字段排序
        if(params.get(com.pmp.common.utils.Constant.ORDER)!=null && params.get(com.pmp.common.utils.Constant.ORDER_FIELD)!=null){

            SQLFilter.sqlInject((String) params.get(com.pmp.common.utils.Constant.ORDER_FIELD));


            if(com.pmp.common.utils.Constant.ASC.equalsIgnoreCase(params.get(com.pmp.common.utils.Constant.ORDER).toString())) {
                return page.setAsc(params.get(com.pmp.common.utils.Constant.ORDER_FIELD).toString());
            }else {
                return page.setDesc(params.get(com.pmp.common.utils.Constant.ORDER_FIELD).toString());
            }
        }

        return page;
    }
}




























