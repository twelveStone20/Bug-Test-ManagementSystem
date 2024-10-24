package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.TeamMapper;
import com.example.demo.pojo.user.User;
import com.example.demo.pojo.user.team.AddTeamRequirement;
import com.example.demo.pojo.user.team.Team;
import com.example.demo.service.TeamService;

@Component
public class TeamServiceImpl implements TeamService{

    @Autowired
    TeamMapper teamMapper;

    @Override
    @Transactional
    public Team addTeam(AddTeamRequirement req){
        Team newTeam=new Team();
        newTeam.setTeamName(req.getTeamName());
        newTeam.setTeamMemberNumber(1);
        User oneUser=new User();
        oneUser.setUserId(req.getTeamManagerId());
        oneUser.setUsername(req.getTeamManagerName());
        newTeam.setTeamManager(oneUser);
        teamMapper.addTeam(newTeam);
        int teamId=teamMapper.getNewTeamId(newTeam);
        newTeam.setTeamId(teamId);
        teamMapper.addCreatorTeam(newTeam);
        return newTeam;
    }

    @Override
    public Team getTeamInfo(int id){
        Team t=teamMapper.getTeamInfo(id);
        return t;
    }

}
