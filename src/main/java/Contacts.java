import java.util.List;

public interface Contacts {

    // List all the contacts (List<Contact>)
    List<Contact> getContacts();

    // Method for saving a contact
    // will essentially for the length of the List<Contact> and +1
    Long saveContact(Contact contact);

    // Method for deleting contact
    void deleteContactById(long id);

    // Method for getting a contact by their ID
    Contact getContactByID(long id);
}
