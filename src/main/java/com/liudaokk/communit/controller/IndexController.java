package com.liudaokk.communit.controller;
import com.liudaokk.communit.mapper.UserMapper;
import com.liudaokk.communit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/16 - 14:09
 */

@Controller
public class IndexController {
    @SuppressWarnings("all")
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){

        //从客户端获取所以cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0)
        //遍历所有cookies
        for (Cookie cookie : cookies) {
            //判断哪个cookies的key是token
            if (cookie.getName().equals("token")){
                //那到名字为token的cookies
                String token = cookie.getValue();
                //查询数据库中的token
              User user = userMapper.findByTocken(token);
              //判断一下user拿到值了没有
                if(user!=null){
                    //设置到session中 让前端页面拿到
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
