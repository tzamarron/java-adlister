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
                                rs.getLong("users_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        // Return ArrayList with all Ads from DB
        System.out.println(allAds);
        return allAds;
    }

    @Override
    public Long insert(Ad ad) {
        long newAdId = 0;

        // Query DB to add Ad
        String addAd = String.format(
                "INSERT INTO " +
                "ads (users_id, title, description) " +
                "VALUES (%d, '%s', '%s');",
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

            // Save Statement from line 79 to a ResultSet
            ResultSet rs = stmt.getGeneratedKeys();

            // Set new Ad id in the DB to newAdId variable
            rs.next();
            newAdId = rs.getLong(1);

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return newAdId;
    }

    public static void main(String[] args) throws SQLException {
        List<Ad> ads = new ArrayList<>();

    }

}
