package DAO;

import Model.User;
import Connection.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao 
{

    public static int save(User user)
    {
        int status = 0;
        try (Connection conn = DatabaseUtil.getConnection()) 
        {
            String sql = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int update(User user) {
        int status = 0;
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "UPDATE users SET name=?, email=?, country=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setInt(4, user.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static User getUserById(int id) {
        User user = new User();
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setCountry(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setCountry(rs.getString(4));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

