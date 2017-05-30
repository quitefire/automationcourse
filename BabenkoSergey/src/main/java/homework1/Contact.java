package homework1;

/**
 * Created by Serhii Babenko on 29.05.2017.
 */
public class Contact {
    private String firstName, lastName, phoneNumber;

    /**
     * @param firstName   - contact first name;
     * @param lastName    - contact last name;
     * @param phoneNumber - contact phone number;
     */
    public Contact(String firstName, String lastName, String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        if (firstName == null && firstName.isEmpty()) throw new NullPointerException("First name is null");
        // or throw IllegalArgumentException() ;
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new NullPointerException("Last name is null");
        // or throw IllegalArgumentException() ;
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = validatePhoneFormat(phoneNumber);
    }

    /**
     * @param phone
     * @return true if phone number is correct another return false;
     */
    public String validatePhoneFormat(String phone) {
        if (phone == null || phone.matches("\\d") || phone.length()<10) throw new IllegalArgumentException("Phone number is not valid"); // "\\d{10}" does not check if phone numbers contains <10 characters
        return phone;
    }

    @Override
    public String toString() {
        return (firstName + " " + lastName + " " + phoneNumber + "\n");
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Contact) {
            if (obj == this) return true;
            Contact contact = (Contact) obj;
            return this.firstName.equals(contact.firstName) && this.lastName.equals(contact.lastName)
                    && this.phoneNumber.equals(contact.phoneNumber);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.firstName.hashCode();
        result = 31 * result + this.lastName.hashCode();
        result = 31 * result + this.phoneNumber.hashCode();
        return result;
    }
}
