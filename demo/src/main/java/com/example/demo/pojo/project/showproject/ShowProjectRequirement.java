package com.example.demo.pojo.project.showproject;

public class ShowProjectRequirement {
    private int managerId;

    public ShowProjectRequirement() {
    }

    public ShowProjectRequirement(int managerId) {
        this.managerId = managerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "ShowProjectRequirement [managerId=" + managerId + "]";
    }
    
}
