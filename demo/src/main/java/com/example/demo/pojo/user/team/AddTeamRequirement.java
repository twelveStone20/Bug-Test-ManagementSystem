package com.example.demo.pojo.user.team;

public class AddTeamRequirement {
    private int teamId;
    private String teamName;
    private int teamMemberNumber;
    private int teamManagerId;
    private String teamManagerName;
    public AddTeamRequirement() {
    }
    public AddTeamRequirement(int teamId, String teamName, int teamMemberNumber, int teamManagerId, String teamManagerName) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamMemberNumber = teamMemberNumber;
        this.teamManagerId = teamManagerId;
        this.teamManagerName = teamManagerName;
    }
    
    public int getTeamId() {
        return teamId;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public int getTeamMemberNumber() {
        return teamMemberNumber;
    }
    public void setTeamMemberNumber(int teamMemberNumber) {
        this.teamMemberNumber = teamMemberNumber;
    }
    
    public int getTeamManagerId() {
        return teamManagerId;
    }
    public void setTeamManagerId(int teamManagerId) {
        this.teamManagerId = teamManagerId;
    }
    public String getTeamManagerName() {
        return teamManagerName;
    }
    public void setTeamManagerName(String teamManagerName) {
        this.teamManagerName = teamManagerName;
    }
    @Override
    public String toString() {
        return "AddTeamRequirement [teamId=" + teamId + ", teamName=" + teamName + ", teamMemberNumber="
                + teamMemberNumber + ", teamManagerId=" + teamManagerId + ", teamManagerName=" + teamManagerName + "]";
    }
    
}
