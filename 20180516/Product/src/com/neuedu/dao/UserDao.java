package com.neuedu.dao;

import com.neuedu.pojo.User;

public interface UserDao {
    public void addOneUser(User user);

    public boolean login(User user);

    public  boolean check(String str);
}
