package com.example.boot02.entity;

/**
 * @author Freg
 * @time 2022/9/7  9:23
 */
public class User {
    private String username;
    private String password;
    private String nick;

    public User() {
    }

    public User(String username, String password, String nick) {
        this.username = username;
        this.password = password;
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nick='" + nick + '\'' +
                '}';
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
