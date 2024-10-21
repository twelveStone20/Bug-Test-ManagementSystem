package com.example.demo.pojo.user;

import java.time.LocalDateTime;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private LocalDateTime registerTime;
    private LocalDateTime loginTime;
    public User(){

    }
    public User(Integer userId, String username, String password, LocalDateTime registerTime, LocalDateTime loginTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.registerTime = registerTime;
        this.loginTime = loginTime;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }   
    public LocalDateTime getRegisterTime() {
        return registerTime;
    }
    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }
    public LocalDateTime getLoginTime() {
        return loginTime;
    }
    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", registerTime="
                + registerTime + ", loginTime=" + loginTime + "]";
    }
}
