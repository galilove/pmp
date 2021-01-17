package com.pmp.server.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录和主页面操作controller
 *
 * @author gali
 * @date 2021/01/16 16:31
 **/
@Controller
public class SysIndexController {
    //模块业务跳转
    @RequestMapping("modules/{module}/{page}.html")
    public String page(@PathVariable String module, @PathVariable String page){
        return "modules/"+module+"/"+page;
    }

    @RequestMapping(value = {"index.html","/"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"login.html"})
    public String login(){
        if (SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:index.html";
        }
        return "login";
    }
    @RequestMapping(value = {"main.html"})
    public String main(){
        return "main";
    }
    @RequestMapping("404.html")
    public String notFound(){
        return "404";
    }
}
