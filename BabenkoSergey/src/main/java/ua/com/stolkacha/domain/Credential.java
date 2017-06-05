package ua.com.stolkacha.domain;

/**
 * Created by Serhii Babenko on 6/5/2017.
 */
public class Credential {

        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String passwordConfirmation;


    /**
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param passwordConfirmation
     */
    public Credential(String firstName, String lastName, String email, String password, String passwordConfirmation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }
}
