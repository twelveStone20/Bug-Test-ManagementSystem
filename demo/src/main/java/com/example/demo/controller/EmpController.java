package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Emp;
import com.example.demo.pojo.Result;
import com.example.demo.service.EmpService;
//import com.example.demo.service.impl.EmpServiceImpl;


@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result listEmp() throws Exception{
        List<Emp> empList=empService.listEmp();
        return Result.success(empList);
    }
}
