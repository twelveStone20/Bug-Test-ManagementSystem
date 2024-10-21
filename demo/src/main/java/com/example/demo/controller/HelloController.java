package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Result;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("Hello World~");
        return Result.success("Hello World~");
    }
}
