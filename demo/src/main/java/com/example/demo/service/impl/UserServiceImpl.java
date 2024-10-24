package com.example.demo.service.impl;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.TeamMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.user.User;
import com.example.demo.pojo.user.login.RegisterRequirement;
import com.example.demo.pojo.user.team.Team;
//import com.example.demo.dao.impl.UserDaoImpl;
import com.example.demo.service.UserService;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired TeamMapper teamMapper;

    @Override
    public List<User> listUser(){
        List<User> userList=userMapper.userlist();
        return userList;
    }
    @Override
    @Transactional
    public User register(RegisterRequirement request){
        if(request.getPassword().equals(request.getRepassword())){
            User newUser=new User();
            newUser.setUsername(request.getUsername());
            newUser.setPassword(request.getPassword());
            newUser.setRegisterTime(LocalDateTime.now());
            userMapper.insert(newUser);
            Team newTeam=new Team();
            newTeam.setTeamName(request.getUsername()+"Team");
            newTeam.setTeamMemberNumber(1);
            int creatorId=userMapper.getUserId(newUser);
            newUser.setUserId(creatorId);
            newTeam.setTeamManager(newUser);
            teamMapper.addTeam(newTeam);
            int teamId=teamMapper.getNewTeamId(newTeam);
            newTeam.setTeamId(teamId);
            teamMapper.addCreatorTeam(newTeam);
            return newUser;
        }else{
            
            return null;
        }
        
    }

    @Override
    public User login(User user){
        User u=userMapper.getByUsernameAndPassword(user);
        u.setLoginTime(LocalDateTime.now());
        userMapper.updateLoginTime(u);
        return u;
    }
    
    @Override
    public User getUserInfo(Integer id){
        return userMapper.getByUserId(id);
    }

}
