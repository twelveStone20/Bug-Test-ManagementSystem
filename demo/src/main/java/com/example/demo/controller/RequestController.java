package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.user.User;

@RestController
public class RequestController {
    @RequestMapping("/simpleParam")
    public String simpleParam(String name,Integer age){
        System.out.println(name+":"+age);
        return "OK";
    }
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "OK";
    }
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }
    @RequestMapping("/JsonParam")
    public String JsonParam(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }
}
