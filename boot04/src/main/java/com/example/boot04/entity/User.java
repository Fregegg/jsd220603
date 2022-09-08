package com.example.boot04.entity;

/**
 * @author Freg
 * @time 2022/9/8  11:00
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nick;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public User(Integer id, String username, String password, String nick) {
        this.id = id;
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
