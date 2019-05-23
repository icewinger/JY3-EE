package com.neuedu.dao;

import com.neuedu.user.User;

import java.util.List;

/*
查询用户的DAO
 */
public interface UserDao {
    List<User> getAllUser();
}
