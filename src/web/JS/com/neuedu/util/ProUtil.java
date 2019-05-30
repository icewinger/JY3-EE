package com.neuedu.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.SimpleFormatter;

public class ProUtil {


    //将字符串类型的日期装换成Date类型的方法
    public static Date getStringConverseDate(String str)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            java.util.Date parse = sdf.parse(str);
            date = new Date(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public static void main(String[] args) {
        Date nowDate = getNowDate();
        System.out.println(nowDate);
    }
    public static Date getNowDate()
    {
        Date date = new Date(new java.util.Date().getTime());
        return date;

    }

    /*
    生成商品ID的方法
     */
    public static String getProId()
    {
        Random random = new Random();
        int i = random.nextInt(100);
        String str = String.valueOf(System.currentTimeMillis());
        if (i<10)
        {
            str += "0" + i;
            return str;
        }else {

        return str + i ;
        }

    }

}
