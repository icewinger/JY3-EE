package com.neuedu.dao;
/*
UserDao接口
 */
public interface UserDao {
     void regsiter(String user,String psw);
     public boolean check(String username) ;
}
