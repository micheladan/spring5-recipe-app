package com.rsegrp.spring5recipeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"","/","index"})
    public String getIndexPage(){
        return "index";
    }
}
