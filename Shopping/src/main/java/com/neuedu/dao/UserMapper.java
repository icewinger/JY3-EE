package com.neuedu.dao;

import com.neuedu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(User record);

//    查询用户名是否存在
    int selectUserByUserName(String username);

//    根据用户名密码查询用户
    User selectUserInfoByUsernameAndPsw(@Param("name") String username, @Param("psw") String password);

//  查询邮箱是否存在
    int selectEmailExists(String email);

//    根据用户名查询密保问题
    String getQuesByUsername(String username);

//    查询用户名答案是否存在
    int quenyUserAnswerIsExists(@Param("username") String username ,@Param("question")String question ,@Param("answer")String answer);

//  根据用户名修改密码
    int updateUserPswByUsername(@Param("username")String username,@Param("newpsw") String newpsw);




}