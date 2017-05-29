package homework1;

/**
 * Created by Serhii Babenko on 29.05.2017.
 */
public class Contact {
    private String firstName, lastName, phoneNumber;

    /**
     * @param firstName   - contact first name;
     * @param lastName    - contact first name;
     * @param phoneNumber - contact first name;
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
        if (firstName.equals(null)) {
            throw new NullPointerException("First name is null");
        } else this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.equals(null)) {
            throw new NullPointerException("First name is null");
        } else this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!isPhoneValid(phoneNumber)) {
            new Exception("Phone number is not valid");
        } else {
            if (phoneNumber.equals(null)) {
                throw new NullPointerException("First name is null");
            } else this.phoneNumber = phoneNumber;
        }
    }

    /**
     * @param phone
     * @return true if phone number is correct another return false;
     */
    public boolean isPhoneValid(String phone) {
        // TO DO validation for +38
        return phone.matches("\\d+");

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
