package com.example.demo.controller.testcase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.test.usecaselibrary.UsecaseLibrary;
import com.example.demo.service.UsecaseLibraryService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsecaseLibraryController {
    @Autowired
    private UsecaseLibraryService usecaseLibraryService;

    @PostMapping("/addusecaselib")
    public Result addUsecaseLib(@RequestBody UsecaseLibrary oneUsecaseLibrary){
        UsecaseLibrary ul=usecaseLibraryService.addUsecaseLibrary(oneUsecaseLibrary);
        return ul!=null?Result.success(ul):Result.error("输入错误");
    }

    @GetMapping("/allusecaselib/{teamId}")
    public Result AllUsecaseLib(@PathVariable int teamId){
        List<UsecaseLibrary> ull=usecaseLibraryService.allUsecaseLibrary(teamId);
        return ull!=null?Result.success(ull):Result.error("没有数据");
    }

    @GetMapping("oneusecaselib/{usecaseLibId}")
    public Result OneUsecaseLib(@PathVariable int usecaseLibId){
        UsecaseLibrary ul=usecaseLibraryService.oneUsecaseLibrary(usecaseLibId);
        return ul!=null?Result.success(ul):Result.error("没有数据");
    }

}
