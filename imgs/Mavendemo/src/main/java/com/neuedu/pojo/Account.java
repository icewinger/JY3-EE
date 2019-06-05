package com.neuedu.pojo;

import lombok.Data;

@Data
public class Account {

    public Account(Integer id, String name, Integer deposit) {
        this.id = id;
        this.name = name;
        this.deposit = deposit;
    }

    private Integer id;
    private String name;
    private Integer deposit;
}
