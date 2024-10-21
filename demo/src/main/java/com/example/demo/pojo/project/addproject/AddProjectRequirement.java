package com.example.demo.pojo.project.addproject;


public class AddProjectRequirement {
    private String projectName;
    private int managerId;
    private String managerName;
    private int priority;
    public AddProjectRequirement() {
    }
    public AddProjectRequirement(String projectName, int managerId, String managerName, int priority) {
        this.projectName = projectName;
        this.managerId = managerId;
        this.managerName = managerName;
        this.priority = priority;
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
    @Override
    public String toString() {
        return "AddProjectRequirement [projectName=" + projectName + ", managerId=" + managerId + ", managerName="
                + managerName + ", priority=" + priority + "]";
    }
    
}
