package com.neuedu.service;

import com.neuedu.common.Const;
import com.neuedu.common.GuavaCache;
import com.neuedu.common.ServletResponse;
import com.neuedu.common.StatusCode;
import com.neuedu.dao.UserMapper;
import com.neuedu.pojo.User;
import com.neuedu.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserServiceimpl implements UserService {

    //根据用户名和密码查询用户信息
    @Autowired
    private UserMapper um;

    @Override
    public ServletResponse Login(String username, String password, HttpSession session) {


        if (username == null || username.length() == 0)
        {
            return ServletResponse.getRequestFailed("用户名不能为空");
        }
        if (password == null || password.length() == 0)
        {
            return ServletResponse.getRequestFailed("密码不能为空");
        }
        String s = MD5Util.MD5Encode(password,null);
        int i = um.selectUserByUserName(username);
        if (i == 0)
        {
            return ServletResponse.getRequestFailed("用户名不存在，请重新输入");
        }
        User user = um.selectUserInfoByUsernameAndPsw(username, s);
        if (user == null )
        {
            return ServletResponse.getRequestFailed("用户名或密码错误");
        }
        session.setAttribute(Const.CURRENTUSER,user);
        return ServletResponse.getRequestSuccess("登陆成功",user);
    }

    //    注册
    @Override
    public ServletResponse register(User user) {
        if (!StringUtils.isNotBlank(user.getUsername()))
        {
            return ServletResponse.getRequestFailed("用户名错误");
        }
        if (!StringUtils.isNotBlank(user.getPassword()))
        {
            return ServletResponse.getRequestFailed("密码错误");
        }
        if (!StringUtils.isNotBlank(user.getEmail()))
        {
            return ServletResponse.getRequestFailed("邮箱错误");
        }
        if (!StringUtils.isNotBlank(user.getPhone()))
        {
            return ServletResponse.getRequestFailed("联系方式错误");
        }
        if (!StringUtils.isNotBlank(user.getQuestion()))
        {
            return ServletResponse.getRequestFailed("密保问题错误");
        }
        if (!StringUtils.isNotBlank(user.getAnswer()))
        {
            return ServletResponse.getRequestFailed("密保答案错误");
        }
//        判断用户是否存在
        ServletResponse servletResponse = checkViled(user.getUsername(), Const.USERNAME);
        if (servletResponse.getStatus() == StatusCode.FAILED)
        {
            return ServletResponse.getRequestFailed("用户名已存在");
        }

//        判断邮箱是否存在
        ServletResponse servletResponse2 = checkViled(user.getEmail(), Const.EMAIL);
        if (servletResponse2.getStatus() == StatusCode.FAILED)
        {
            return ServletResponse.getRequestFailed("邮箱已存在");
        }

//        给密码加密
        String s = MD5Util.MD5Encode(user.getPassword(), null);
        user.setPassword(s);

//        为用户设置角色
        user.setRole(Const.COMMONUSER);

//        调用添加的方法
        int insert = um.insert(user);
        if (insert == 0 )
        {
            return ServletResponse.getRequestFailed("注册失败...");
        }
        return ServletResponse.getRequestSuccess("注册成功");
    }

//获取登陆用户信息
    @Override
    public ServletResponse get_user(HttpSession session) {

        Object user = session.getAttribute("user");
        if (null == user)
        {
            return ServletResponse.getRequestFailed("用户未登录，无法获取当前用户信息");
        }
        return ServletResponse.getRequestSuccess(user);
    }

    //    获取密保问题
    @Override
    public ServletResponse forget_PswQues(String username) {
        if (!StringUtils.isNotBlank(username))
        {
            return ServletResponse.getRequestFailed("输入用户名为空");
        }
        ServletResponse servletResponse = this.checkViled(username, Const.USERNAME);
        if (servletResponse.isReqSuccess())
        {
            return ServletResponse.getRequestFailed("没有此用户");
        }
        String quesByUsername = um.getQuesByUsername(username);
        return ServletResponse.getRequestSuccess(quesByUsername);
    }

    //    提交问题答案
    @Override
    public ServletResponse forget_check_answer(String username, String question, String answer) {

        if (!StringUtils.isNotBlank(username))
        {
            return ServletResponse.getRequestFailed("用户名不能为空");
        }
        if (!StringUtils.isNotBlank(question))
        {
            return ServletResponse.getRequestFailed("问题不能为空");
        }
        if (!StringUtils.isNotBlank(answer))
        {
            return ServletResponse.getRequestFailed("答案不能为空");
        }
        int i = um.quenyUserAnswerIsExists(username, question, answer);
        if (i>0)
        {
            String uuid = UUID.randomUUID().toString();
            GuavaCache.putCache(Const.TOKENCACHE,uuid);
            return ServletResponse.getRequestSuccess("验证成功",uuid);
        }
        return ServletResponse.getRequestFailed("回答错误...");
    }

//    忘记密码的重置密码
    @Override
    public ServletResponse forget_reset_password(String username, String passwordNew, String token) {
        if (!StringUtils.isNotBlank(username))
        {
            return ServletResponse.getRequestFailed("用户名不能为空");
        }
        if (!StringUtils.isNotBlank(passwordNew))
        {
            return ServletResponse.getRequestFailed("修改的密码不能为空");
        }
        if (!StringUtils.isNotBlank(token))
        {
            return ServletResponse.getRequestFailed("token不能为空");
        }
        String cache = GuavaCache.getCache(Const.TOKENCACHE);
        if (StringUtils.isNotBlank(cache))
        {
            if (StringUtils.equals(cache,token))
            {
                String s = MD5Util.MD5Encode(passwordNew, null);
                int i = um.updateUserPswByUsername(username,s);
                if (i>0)
                {
                    return ServletResponse.getRequestSuccess("修改密码成功");
                }
            }
        }
        return ServletResponse.getRequestFailed("修改密码失败");
    }

//    登录状态修改密码
    @Override
    public ServletResponse resetPassword(HttpSession session,String passwordOld, String passwordNew) {
        User user =(User)session.getAttribute(Const.CURRENTUSER);
        if (null == user)
        {
            return ServletResponse.getRequestFailed("未登录。。。请重新登陆后使用");
        }

        if (!StringUtils.isNotBlank(passwordOld))
        {
            return ServletResponse.getRequestFailed("旧密码不能为空");
        }
        if (!StringUtils.isNotBlank(passwordNew))
        {
            return ServletResponse.getRequestFailed("新密码不能为空");
        }
        if (StringUtils.equals(passwordNew,passwordOld))
        {
            return ServletResponse.getRequestFailed("新密码不能与旧密码一致");
        }
        //判断旧密码是否正确
        if (!StringUtils.equals(passwordOld,user.getPassword()))
        {
            return ServletResponse.getRequestFailed("旧密码输入错误");
        }


        //修改密码
        String s = MD5Util.MD5Encode(passwordNew, null);

        int i = um.updateUserPswByUsername(user.getUsername(), s);
        if (i>0)
        {
            user.setPassword(s);
            session.setAttribute(Const.CURRENTUSER,user);
            return ServletResponse.getRequestSuccess("修改密码成功");

        }
        return ServletResponse.getRequestFailed("修改密码失败");
    }

    //登录状态修改个人信息
    @Override
    public ServletResponse updateInformation(HttpSession session, User user) {
        //判断是否登录
        User LoginUser =(User) session.getAttribute(Const.CURRENTUSER);
        if (null == LoginUser)
        {
            return ServletResponse.getRequestFailed("未登录");
        }
        if (StringUtils.isNotBlank(user.getEmail()))
        {
            ServletResponse servletResponse = this.checkViled(user.getEmail(), Const.EMAIL);
            if (servletResponse.getStatus() == StatusCode.FAILED)
            {
                return ServletResponse.getRequestFailed("邮箱已存在，请重新输入");
            }
        }

        int i = um.updateByPrimaryKeySelective(user);
        if (i>0)
        {
            return ServletResponse.getRequestSuccess("修改成功");
        }
        return ServletResponse.getRequestFailed("修改失败");
    }

    @Override
    public ServletResponse logout(HttpSession session) {
        session.removeAttribute(Const.CURRENTUSER);
        if (null == session.getAttribute(Const.CURRENTUSER))
        {
            return ServletResponse.getRequestSuccess("退出成功");
        }
        return ServletResponse.getRequestFailed("退出失败");
    }


    //        检查用户名和邮箱是否有效
    public ServletResponse checkViled(String val,String type)
    {
        if (!StringUtils.isNotBlank(val))
        {
            return ServletResponse.getRequestFailed("请输入对应的值");
        }
        if (StringUtils.isNotBlank(type))
        {
            if (Const.USERNAME == type)
            {
                int i = um.selectUserByUserName(val);
                if (i > 0)
                {
                    return ServletResponse.getRequestFailed("用户名已存在");
                }
            }

            if (Const.EMAIL == type)
                {
                    int i = um.selectEmailExists(val);
                    if (i > 0)
                    {
                        return ServletResponse.getRequestFailed("邮箱已存在");
                    }
                }

        }else {
            return ServletResponse.getRequestFailed("校验类型有误");
        }
        return ServletResponse.getRequestSuccess("通过验证");
    }
}
