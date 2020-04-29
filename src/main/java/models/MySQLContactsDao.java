package models;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySQLContactsDao implements Contacts{
    // Set up the DB connection
    private Connection conn;

    public MySQLContactsDao() throws SQLException {
        // Instantiate a models.Config object
        Config config = new Config();

        // Set up our database driver and make a connection
        DriverManager.registerDriver(new Driver());

        // Get a connection object
        this.conn = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        ); // we now have a connection to our MySQL DB
    }

    @Override
    public List<Contact> getContacts() {
        return null;
    }

    @Override
    public Long saveContact(Contact contact) {
        return null;
    }

    @Override
    public void deleteContactById(long id) {

    }

    @Override
    public Contact getContactByID(long id) {
        return null;
    }
}
