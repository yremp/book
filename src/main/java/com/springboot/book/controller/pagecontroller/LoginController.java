package com.springboot.book.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
   @RequestMapping(value = "user/login",method = RequestMethod.POST)
//    @PostMapping(value = "user/login")
   public String login(@RequestParam("username")String username,
                       @RequestParam("password")String password,
                       Map<String, Object> map, HttpSession httpSession){
       if(!StringUtils.isEmpty(username)&&"123456".equals(password))
       {httpSession.setAttribute("user",username);
           return "redirect:/mainui.html";
       }
       else
       {
           map.put("mes","用户名或者密码错误");
           return "login";

       }
    }
}
