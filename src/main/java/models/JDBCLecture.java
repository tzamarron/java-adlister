package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class JDBCLecture {

    public static void main(String[] args) throws SQLException {

        // Instantiate a models.Config object
        Config config = new Config();

        // Set up our database driver and make a connection
        DriverManager.registerDriver(new Driver());

        // Get a connection object
        Connection conn = DriverManager.getConnection(
            config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }
}
