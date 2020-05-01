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
        User user = new User();
        try {
            String sql = "SELECT * FROM users WHERE username = ?;";
            String findUsername = "%" + username + "%";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,findUsername);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            System.out.println("User not found!");
            throw new RuntimeException("Error creating a new ad.", e);
        }
        return user;
    }

    @Override
    public Long insert(User user) {
        long id = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(getInsertQuery(), Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            id = rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
//            System.err.printf(e.getMessage()); //prints red text in error log
        }

        return id;
    }

    private String getInsertQuery() {
        return "INSERT INTO users(username, email, password) VALUES (?, ?, ?);";
    }
}
