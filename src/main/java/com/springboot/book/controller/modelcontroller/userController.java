package com.springboot.book.controller.modelcontroller;

import com.springboot.book.dao.UserDao;
import com.springboot.book.model.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class userController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/query")
    @ResponseBody
    public JSONObject queryAll()
    {
        List<User> users = userDao.selectAll();
        JSONObject json =new JSONObject();
        json.put("data",users);
        return json;
    }
}
