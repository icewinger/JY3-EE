package com.neuedu.service;

import com.neuedu.common.ServletResponse;
import com.neuedu.pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    //根据用户名和密码查询用户信息
    public ServletResponse Login(String username, String password, HttpSession session);


//    注册
    public ServletResponse register(User user);


//获取登陆用户信息
    public ServletResponse get_user(HttpSession session);

//    获取密保问题
    public ServletResponse forget_PswQues(String username);

//    提交问题答案
    public ServletResponse forget_check_answer(String username,String question,String answer);

//    忘记密码的重置密码
    public ServletResponse forget_reset_password(String username,String passwordNew,String token);


//    登录状态下的重置密码
    public ServletResponse resetPassword(HttpSession session,String passwordOld,String passwordNew);

//    登陆状态下修改个人信息
    public ServletResponse updateInformation(HttpSession session,User user);

//     退出登录
    public ServletResponse logout(HttpSession session);
}
