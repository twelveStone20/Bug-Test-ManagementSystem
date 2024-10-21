package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.user.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/userList")
    public Result list(){
        List<User> userList=userService.listUser();
        return Result.success(userList);
    }
    

}
