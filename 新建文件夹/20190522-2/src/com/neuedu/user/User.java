package com.neuedu.user;

import com.neuedu.DruidDataSource.DruidDataSource;

public class User {
    private Integer id;
    private String username;

    private String psw;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }

    public User(){

    }

    public User(Integer id, String username, String psw) {
        this.id = id;
        this.username = username;
        this.psw = psw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
