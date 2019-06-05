package com.neuedu.dao;

import com.neuedu.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;

public class AccountDaoimpl implements AccountDao {

    private SqlSessionFactory ssf;

    public AccountDaoimpl(){
        try {
            ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Account getAccountById(Integer id) {
        SqlSession sqlSession = ssf.openSession();
        Account getOneDept = sqlSession.selectOne("getOneDept", id);
        return getOneDept;
    }

    @Override
    public Integer addOneAccountAndReturnId(Account account) {
        SqlSession sqlSession = ssf.openSession();
        int addOneAccount = sqlSession.insert("addOneAccountReturnId", account);
        sqlSession.commit();
        return addOneAccount;
    }
}
