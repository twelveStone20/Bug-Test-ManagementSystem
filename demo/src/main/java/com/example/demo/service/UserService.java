package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.user.User;
import com.example.demo.pojo.user.login.RegisterRequirement;

public interface UserService {
    public List<User> listUser();
    public User register(RegisterRequirement request);
    public User login(User user);
    public User getUserInfo(Integer id);
}
