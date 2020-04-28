public class Contact {
    private long id; // int goes from -2bil to 2bil // default is set to 0
                    // unsigned int goes from 0 to 4bil
                    // int would be too small, so we use long
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor, Getters and Setters

    // zero-argument constructor
    public Contact() {
    }

    // assuming we only get first/last name and phone number
    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // assuming we get first/;ast/phone AND id
    public Contact(long id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
