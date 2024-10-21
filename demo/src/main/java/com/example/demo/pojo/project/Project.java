package com.example.demo.pojo.project;

import java.time.LocalDateTime;


public class Project {
    private int projectId;
    private String projectName;
    private int managerId;
    private String managerName;
    private int priority;
    
    private int projectStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    public Project() {
    }
    public Project(int projectId, String projectName, int managerId, String managerName, int priority, int projectStatus, LocalDateTime createTime,
            LocalDateTime updateTime) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.managerId = managerId;
        this.managerName = managerName;
        this.priority = priority;
        this.projectStatus=projectStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public int getManagerId() {
        return managerId;
    }
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getProjectStatus() {
        return projectStatus;
    }
    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    @Override
    public String toString() {
        return "Project [projectId=" + projectId + ", projectName=" + projectName + ", managerId=" + managerId
                + ", managerName=" + managerName + ", priority=" + priority + ", projectStatus=" + projectStatus
                + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }
    
}
