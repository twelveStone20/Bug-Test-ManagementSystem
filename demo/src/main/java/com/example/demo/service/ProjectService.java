package com.example.demo.service;

import java.util.List;
import com.example.demo.pojo.project.Project;
import com.example.demo.pojo.project.addproject.AddProjectRequirement;

public interface ProjectService {
    public Project addProject(AddProjectRequirement request);
    public List<Project> allProject(int id);
    public void deleteProject(int projectId);
}
