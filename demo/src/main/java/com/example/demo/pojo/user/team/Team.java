package com.example.demo.pojo.user.team;

import com.example.demo.pojo.user.User;

public class Team {
    private int teamId;
    private String teamName;
    private int teamMemberNumber;
    private User teamManager;
    public Team() {
        teamMemberNumber=0;
    }
    public Team(int teamId, String teamName, int teamMemberNumber, User teamManager) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamMemberNumber = teamMemberNumber;
        this.teamManager = teamManager;
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
    public User getTeamManager() {
        return teamManager;
    }
    public void setTeamManager(User teamManager) {
        this.teamManager = teamManager;
    }
    @Override
    public String toString() {
        return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamMemberNumber=" + teamMemberNumber
                + ", teamManager=" + teamManager + "]";
    }
}
