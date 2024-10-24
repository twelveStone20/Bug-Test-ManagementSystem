package com.example.demo.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.user.team.AddTeamRequirement;
import com.example.demo.pojo.user.team.Team;
import com.example.demo.service.TeamService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/addteam")
    public Result addTeam(@RequestBody AddTeamRequirement req){
        Team t= teamService.addTeam(req);
        return t!=null?Result.success(t):Result.error("错误");
    }

    @GetMapping("/getteaminfo/{id}")
    public Result getTeamInfo(@PathVariable int id) {
        Team t=teamService.getTeamInfo(id);
        return t!=null?Result.success(t):Result.error("team信息错误");
    }
    
}
