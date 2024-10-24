package com.example.demo.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.user.User;
import com.example.demo.pojo.user.login.RegisterRequirement;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody RegisterRequirement request) {
        User u = userService.register(request);
        return u!=null?Result.success(u):Result.error("输入错误");
    }
    
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User u = userService.login(user);
        if(u!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("userId",u.getUserId());
            claims.put("username",u.getUsername());
            claims.put("password",u.getPassword());
            //claims.put("registerTime",u.getRegisterTime());
            //claims.put("loginTime",u.getLoginTime());
            String jwt=JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

    @GetMapping("/userinfo/{id}")
    public Result getUserInfo(@PathVariable Integer id){
        User u=userService.getUserInfo(id);
        return u!=null?Result.success(u):Result.error("获取信息失败");
    }
}
