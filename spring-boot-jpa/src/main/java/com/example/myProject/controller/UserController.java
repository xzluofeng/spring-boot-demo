package com.example.myProject.controller;

import com.example.myProject.domain.User;
import com.example.myProject.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/getUser")
//    @Cacheable(value="jpa-user")
    public User getUser(String search) {
        User user= null;
        if (search != null) {
            user = userRepository.findUserByUsernameIsLike("%" + search + "%");
        }
        return user;
    }

    @RequestMapping("/getUsers")
//    @Cacheable(value="jpa-users")
    public List<User> getUsers() {
        List<User> users=userRepository.findAll();
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return users;
    }

    @RequestMapping("/addUser")
    public String AddUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassWord("123");
        user.setEmail("1234");
        user.setNickName("test");
        user.setRegTime("2019-01-01");
        try {
            userRepository.save(user);
            return "新增成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "新增失败";
        }
    }

}
