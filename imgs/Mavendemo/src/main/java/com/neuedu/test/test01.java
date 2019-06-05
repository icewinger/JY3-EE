package com.neuedu.test;

import com.neuedu.dao.AccountDao;
import com.neuedu.dao.AccountDaoimpl;
import com.neuedu.pojo.Account;
import lombok.Data;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class test01 {

//    @Test
//    public void test()
//    {
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        try {
//            SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
//            SqlSession sqlSession = build.openSession();
//            Account getOneDept = sqlSession.selectOne("getAccountByAccountName", "%马%");
//            System.out.println(getOneDept);
//            List<Account> getAllAccount = sqlSession.selectList("getAllAccount");
//            System.out.println(getAllAccount);
//            Account account = new Account(6, "局座", 666);
//            int addOneAccount = sqlSession.insert("addOneAccount",account);
//            Account account = new Account(6, "张绍忠", 9999999);
//            int updateOneAccount = sqlSession.update("updateOneAccount", account);
//            int delOneAccount = sqlSession.delete("delOneAccount", "6");
//
//
//            sqlSession.commit();
//            sqlSession.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

        private AccountDao ad;

        SqlSessionFactory build ;

       @Before
       public void before()
       {
//            ad = new AccountDaoimpl();
           try {
               build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       @Test
       public void test()
       {
//           Account accountById = ad.getAccountById(5);
//           System.out.println(accountById);
//           Account account = new Account(null, "吾王", 8888888);
//           执行完SQL语句后 查询到的id已经映射到account上了
//           Integer integer = ad.addOneAccountAndReturnId(account);
//           System.out.println(account.getId());
           SqlSession sqlSession = build.openSession();
//          mapper就是AccountDao的实现类
           AccountDao mapper = sqlSession.getMapper(AccountDao.class);
           Account accountById = mapper.getAccountById(5);
           System.out.println(accountById);
       }
        @After
       public void after()
       {

       }
}
