package com.neuedu.controller;

import com.neuedu.common.ServletResponse;
import com.neuedu.pojo.User;
import com.neuedu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/portal/user")
public class UserController {

    @Autowired
    private UserService us;

    @ResponseBody
    @RequestMapping("/login.do")
    public ServletResponse Login(String username, String password, HttpSession session)
    {

        return us.Login(username,password,session);
    }

    @ResponseBody
    @RequestMapping("/register.do")
    public ServletResponse Register(User user)
    {
        return us.register(user);
    }


    //查询密保问题
    @ResponseBody
    @RequestMapping("/forget_get_question.do")
    public ServletResponse queryQues(String username)
    {
        return us.forget_PswQues(username);
    }

//    提交问题答案
    @ResponseBody
    @RequestMapping("/forget_check_answer.do")
    public ServletResponse forget_check_answer(String username,String question,String answer)
    {
        return us.forget_check_answer(username,question,answer);
    }

//    忘记密码中的重设密码
    @ResponseBody
    @RequestMapping("/forget_reset_password.do")
    public ServletResponse forget_reset_password(String username,String passwordNew,String token)
    {
        return us.forget_reset_password(username,passwordNew,token);
    }

//    登录状态中的重置密码
    @ResponseBody
    @RequestMapping("/reset_password.do")
    public ServletResponse reset_password(HttpSession session,String pswOld,String pswNew)
    {
        return us.resetPassword(session,pswOld,pswNew);
    }

//    登陆状态下修改个人信息
    @ResponseBody
    @RequestMapping("/update_information.do")
    public ServletResponse update_information(HttpSession session,User user)
    {
        return us.updateInformation(session,user);
    }
//    退出登录
    @ResponseBody
    @RequestMapping("/logout.do")
    public ServletResponse Logout(HttpSession session)
    {
        return us.logout(session);
    }
}
