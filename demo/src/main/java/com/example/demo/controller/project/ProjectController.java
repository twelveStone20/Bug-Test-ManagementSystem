package com.example.demo.controller.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.project.Project;
import com.example.demo.pojo.project.addproject.AddProjectRequirement;
import com.example.demo.service.ProjectService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/addproject")
    public Result AddProject(@RequestBody AddProjectRequirement request){
        Project p=projectService.addProject(request);
        return p!=null?Result.success(p):Result.error("项目创建失败");
    }

    @GetMapping("/allproject/{managerId}")
    public Result AllProject(@PathVariable int managerId){
        List<Project> projectList=projectService.allProject(managerId);
        return Result.success(projectList);
    }
}
