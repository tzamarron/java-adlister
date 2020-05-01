package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import models.Config;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username LIKE ?";
            String findUsername = "%" + username + "%";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,findUsername);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            return (User) rs.getObject(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Long insert(User user) {
        try {
            PreparedStatement stmt = connection.prepareStatement(getInsertQuery(), Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private String getInsertQuery() {
        return "INSERT INTO users(username, email, password) VALUES (?, ?, ?);";
    }
}
