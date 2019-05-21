package com.neuedu.dao;

import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Changeimpl implements Changepsw {
    @Override
    public void Changepsw(String name, String psw) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE USER \n" +
                "SET psw = ?\n" +
                "WHERE username = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,psw);
            ps.setString(2,name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closePreparedStatement(ps);
            DBUtils.closeConnection(conn);
        }
    }
}
