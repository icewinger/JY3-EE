package com.neuedu.dao;

import com.neuedu.user.user;
import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Queryimpl implements Query {
    @Override
    public List<user> Query() {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT username,psw FROM user";
        List<user> list = new ArrayList();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                String username = rs.getString("username");
                String psw = rs.getString("psw");
                user user = new user(username,psw);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResultSet(rs);
            DBUtils.closePreparedStatement(ps);
            DBUtils.closeConnection(conn);
        }
        return list;
    }

}
