package com.neuedu.dao;

import com.neuedu.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class GetDataByMybatis {

    public static void main(String[] args) {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
            SqlSession sqlSession = build.openSession();
            Account getOneDept = sqlSession.selectOne("getOneDept", "1");
            System.out.println(getOneDept);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
