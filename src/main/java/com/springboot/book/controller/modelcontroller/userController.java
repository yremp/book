package com.springboot.book.controller.modelcontroller;

import com.springboot.book.dao.UserDao;
import com.springboot.book.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class userController {
    @Autowired
    private UserDao userDao;
    private User user;
    @RequestMapping("/user")
    public String ALL(Model model)
    {
        List<User> users=userDao.selectAll();
       model.addAttribute("users",users);
       return "userlist";
    }
    @RequestMapping("/user/lookusers/")
    public String ALLUSERS( Model model)
    {
        List<User> users=userDao.selectAll();
        model.addAttribute("users",users);
        return "editusers";
    }
    @RequestMapping("/user/del/{userId}")
    public String ALL(@PathVariable("userId")Integer userId, Model model)
    {
        userDao.deleteUserById(userId);
        List<User> users=userDao.selectAll();
        model.addAttribute("users",users);
        return "editusers";
    }
    @RequestMapping("/userinfo/predit/{id}")
    public String Editself(@PathVariable("id")String id, Model model){
        int Id =Integer.parseInt(id);
        user =userDao.selectById(Id);
        model.addAttribute("user",user);
        return "userinfo";
    }
    @PostMapping("/userinfo/edit/{id}")
    public String UpdateBook(
                             @PathVariable("id")String id,
                             @RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("password")String password
                           ){
        int Id=Integer.parseInt(id);
        userDao.updateById(Id,name,email,password);
        return "usereditsuccess";
    }

}
