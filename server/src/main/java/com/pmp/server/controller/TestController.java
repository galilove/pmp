package com.pms.server.controller;

import com.pmp.common.response.BaseResponse;
import com.pmp.common.response.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gali~
 * @date 2021-01-16
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public BaseResponse hello(String name){
        BaseResponse response = new BaseResponse(StatusCode.Success);

        Map result = new HashMap(2);
        result.put("name","权限管理系统");

        response.setData(result);

        return response;
    }

    @RequestMapping("/pageOne")
    public String pageOne(String name, ModelMap modelMap){
        modelMap.put("name","权限系统");
        modelMap.put("app","app");
        return "pageOne";
    }
}
