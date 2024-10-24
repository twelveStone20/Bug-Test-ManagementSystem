package com.example.demo.service.impl;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mapper.ProjectMapper;
import com.example.demo.pojo.project.Project;
import com.example.demo.pojo.project.addproject.AddProjectRequirement;
import com.example.demo.service.ProjectService;

@Component
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectMapper projectMapper;
    
    @Override
    public Project addProject(AddProjectRequirement request){
        if(request.getProjectName()!=null){
            Project p=new Project();
            p.setProjectName(request.getProjectName());
            p.setPriority(request.getPriority());
            p.setManagerId(request.getManagerId());
            p.setManagerName(request.getManagerName());
            p.setCreateTime(LocalDateTime.now());
            p.setUpdateTime(LocalDateTime.now());
            projectMapper.addProject(p);
            return p;
        }else{
            return null;
        } 
    }

    @Override
    public List<Project> allProject(int id){
        List<Project> projectList=projectMapper.allProject(id);
        return projectList;
    }

    @Override
    public void deleteProject(int projectId) {
        projectMapper.deleteProject(projectId);
        return;
    }

    
}
