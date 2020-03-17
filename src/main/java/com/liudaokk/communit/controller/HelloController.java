package com.liudaokk.communit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/16 - 14:09
 */

@Controller
public class HelloController {
    @GetMapping("/index")
    public String hello(Model model){
        String name = "六道";
        model.addAttribute("name",name);
        return "index";
    }
}
