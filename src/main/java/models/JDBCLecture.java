package models;

import java.sql.*;

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
        ); // we now have a connection to our MySQL DB

        // Create a statement
        Statement stmt = conn.createStatement();

        // Execute some sort of Query
        // create a query string to get everything in the contacts table
        String contactsQuery = "SELECT * FROM contacts";

        ResultSet rs = stmt.executeQuery(contactsQuery);

        // display what actually is in the result set (rs) above
//        while (rs.next()){
//            System.out.println("First name: " + rs.getString("first_name"));
//            System.out.println("Last name: " + rs.getString("last_name"));
//            System.out.println("phone number: " + rs.getString("phone_number"));
//            System.out.println("------------------------");
//        }

        // If we waant to add a row to our database, we'll:
            // 1: Create a contact object (bean)
            // 2: Use our DAO to add our new contact using the saveContact() method and get the resulting ID
            // 3: Create an SQL Query to insert that Contact object into our database, as a new row using the ID we previously retrieved

        // this will allow us to use the methods defined in our DAO
        Contacts clDao = DaoFactory.getContactsDao(); // This data-access-object allows us to interact with all the contacts

        // Instantiate a new Contact Object (not the norm)
        Contact casey = new Contact("Casey","Friday","2105557777");

        long newContactID = clDao.saveContact(casey); // id (for use in DB) of new contact
        Contact newlyCreatedContact = clDao.getContactByID(newContactID);

        // INSERT INTO contact (first_name,last_name-phone_number) VALUES ('casey', 'friday' '2105557777');

        String addContactQuery = String.format("INSERT INTO contacts (first_name, last_name, phone_number) VALUES ('%s','%s','%s')",newlyCreatedContact.getFirstName(),newlyCreatedContact.getLastName(),newlyCreatedContact.getPhoneNumber());

        System.out.println("This is the query string we'll be sending to MySQL:\n");
        System.out.println(addContactQuery);

        // NOW let's actually execute this SQL query to add the new contact to our database
        stmt.executeUpdate(addContactQuery, Statement.RETURN_GENERATED_KEYS);

        // If we add Statement.RETURN_GENERATED_KEYS, we can work with the actual MySQL DB table row ID's, and reassign those id's to our Contact objects here in our Java code

        long insertedRowID = 0;
        ResultSet ks = stmt.getGeneratedKeys();
        if (ks.next()){
            insertedRowID = ks.getLong(1); // this will save the MySQL row ID to a variable
            System.out.println("The ID of the newly inserted row is: " + ks.getLong(1));
        }
        System.out.println("Beofer doin the MySQL id check, " + newlyCreatedContact.getFirstName() + "'s id was: " + newlyCreatedContact.getId());
        //Check to see if the id was returned, or if insertedRowID is still at it's default of '0'
        if (insertedRowID != 0){
            newlyCreatedContact.setId(insertedRowID);
        }

    }
}
