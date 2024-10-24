package com.example.demo.service;

import com.example.demo.pojo.user.team.AddTeamRequirement;
import com.example.demo.pojo.user.team.Team;

public interface TeamService {
    public Team addTeam(AddTeamRequirement req);
    public Team getTeamInfo(int creator_id);
} 
