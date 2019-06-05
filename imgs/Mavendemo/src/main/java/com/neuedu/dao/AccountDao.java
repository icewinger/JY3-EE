package com.neuedu.dao;

import com.neuedu.pojo.Account;

public interface AccountDao  {

    //根据ID查询Account
    public Account getAccountById(Integer id);

    public Integer addOneAccountAndReturnId(Account account);

}
