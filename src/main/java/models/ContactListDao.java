package models;

import java.util.ArrayList;
import java.util.List;

public class ContactListDao implements Contacts{

    // we need a list variable to hold all the models.Contacts
    private List<Contact> contacts = new ArrayList<>();

    // added contacts_db seeder here if needed

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public Long saveContact(Contact contact) {
        // check to see if this if the first contact, and if so, add 1
        if (contact.getId() == 0){
            // If we're setting up a contact that hasn't been assigned and ID (so it must have
                // been constructed using the 'first', 'last' and 'phone' - NO id, then we want to
            // generate and ID and set it for this contact
            contact.setId(contacts.size() + 1);
            contacts.add(contact);
        } else {
            // we already have the correct ID coming from teh MySQL table, so lets' just se that contact
                // in the ArrayList (contacts) with the ID that was passed in
            contacts.set((int) (contact.getId() -1), contact);
        }

        // return the ID of the newly saved contact
        return contact.getId();
    }

    @Override
    public void deleteContactById(long id) {
        // don't need a return value
        // create a new array list to store a new list without the deleted contact
        contacts.remove( (int)id -1); // sending the index for the Array List
    }

    @Override
    public Contact getContactByID(long id) {
        return contacts.get( (int)id -1 );
    }

    // Lets's test out our DAO to ensure everything is working properly

    public static void main(String[] args) {
        Contacts contactDao = new ContactListDao();

        // test the getContacts() method
        System.out.println("\n=== Testing getContacts()");
        List<Contact> allContacts = contactDao.getContacts();

        for (Contact contact : allContacts){
            System.out.println(contact.getFirstName());
        }
    }
}
