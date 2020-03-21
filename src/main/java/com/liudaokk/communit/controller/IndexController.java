package com.liudaokk.communit.controller;

import com.liudaokk.communit.dto.PaginationDTO;
import com.liudaokk.communit.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/16 - 14:09
 */

@Controller
public class IndexController {
    @SuppressWarnings("all")

    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String index( Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size){

/*        //从客户端获取所以cookies
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
        }*/
        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
