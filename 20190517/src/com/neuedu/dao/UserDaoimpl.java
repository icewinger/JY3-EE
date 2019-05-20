package com.neuedu.dao;

import com.neuedu.utils.DBUtils;

import java.sql.*;

/*

UserDao实现类
 */
public class UserDaoimpl implements UserDao {

    @Override
    public void regsiter(String user, String psw) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO user (username,psw) VALUES (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, psw);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closePreparedStatement(ps);
            DBUtils.closeConnection(conn);
        }
    }

    public boolean check(String username) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String str = "SELECT username FROM user where username = ?";
        try {
            ps = conn.prepareStatement(str);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next())
            {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeResultSet(rs);
            DBUtils.closePreparedStatement(ps);
            DBUtils.closeConnection(conn);
        }
        return true;
    }
}

