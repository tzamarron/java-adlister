package models;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{
    private Connection conn;

    public MySQLAdsDao() throws SQLException {

        // Instantiate Config Object
        Config config = new Config();

        // Setup database Driver
        DriverManager.registerDriver(new Driver());

        // Get a connection object
        this.conn = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() {
        List<Ad> allAds = new ArrayList<>();

        // Query all ads from the SQL DB table
        String query = "SELECT * FROM ads";

        // Handle SQL Exceptions
        try {
            // Create a statement object
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Iterate thru data and add to Array
            while (rs.next()) {
                allAds.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("userId"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        // Return ArrayList with all Ads from DB
        return allAds;
    }

    @Override
    public Long insert(Ad ad) {
        long newAdId = 0;

        // Query DB to add Ad
        String addAd = String.format(
                "INSERT INTO " +
                "ads (id, userId, title, description) " +
                "VALUES (%d, %d, %s, %s)",
                ad.getId(),
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription()
        );

        // Handle SQL Exceptions
        try {
            // Create a statement object
            Statement stmt = conn.createStatement();

            // Execute statement to add the new Ad
            stmt.executeUpdate(addAd, Statement.RETURN_GENERATED_KEYS);

            // Save Statment from line 79 to a ResultSet
            ResultSet rs = stmt.getGeneratedKeys();

            // Set new Ad id in the DB to newAdId variable
            if (rs.next()) {
                newAdId = rs.getLong(1);
            }

            // Set new Ad id in ArrayList to variable if needed so the ArrayList and Db are the same
            if (newAdId != 0) {
                ad.setId(newAdId);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        // Return the new Ad id
        return newAdId;
    }

}
