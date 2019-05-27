package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface ProDao {
    //增加一条新数据
    void addOneProduct(Product product);
    //删除一条数据
    void delOneProduct(String str);
    //查询所有数据
    List<Product> queryAllProduct();
    //改写商品信息
    void changeOneProduct(Object object1,Object object2,Object object3);
}
