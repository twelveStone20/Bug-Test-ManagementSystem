package com.example.demo.pojo.user.login;

public class RegisterRequirement {
    private String username;
    private String password;
    private String repassword;
    public RegisterRequirement() {
    }
    public RegisterRequirement(String username, String password, String repassword) {
        this.username = username;
        this.password = password;
        this.repassword = repassword;
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
    public String getRepassword() {
        return repassword;
    }
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    @Override
    public String toString() {
        return "RegisterRequirement [username=" + username + ", password=" + password + ", repassword=" + repassword
                + "]";
    }
}
