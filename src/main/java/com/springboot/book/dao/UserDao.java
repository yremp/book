package com.springboot.book.dao;

import com.springboot.book.model.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    String table_name="user";
    String insert_filed="id,name,email";
    String select_field = " id, " + insert_filed;

@Select({"select * from ",table_name})
    List<User> selectAll();
//    添加user
    @Insert({"inset into",table_name,"values(#{name},#{email)"})
    User addUser(User user);

//    根据id查询用户
    @Select({"select",select_field,"from",table_name,"where id=#{id}"})
    User selectById(int id);

//    根据用户姓名查询用户信息
    @Select({"select",select_field,"from",table_name,"where name=#{name}"})
    User   selectByName(String name);

//    根据用户邮箱查询用户信息
@Select({"select",select_field,"from",table_name,"where email=#{email}"})
    User selectByEmail(String email);
}
