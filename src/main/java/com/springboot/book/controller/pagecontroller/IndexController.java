package com.springboot.book.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/","/index.html"})
    public String loginPage1()
    {
        return "login";
    }
}
