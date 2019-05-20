package com.neuedu.dao;

import com.neuedu.user.user;
import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Loginimpl implements Login{

    @Override
    public boolean Login(user user) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        String sql = "SELECT username,psw FROM user WHERE username = ? and psw = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs = ps.executeQuery();
            if (rs.next())
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResultSet(rs);
            DBUtils.closePreparedStatement(ps);
            DBUtils.closeConnection(conn);
        }
        return false;
    }
}
