package automation.hotline.model;

public class RegistrationData {
    private String email;
    private String nick;
    private String password;

    public RegistrationData(String email, String nick, String password) {
        this.email = email;
        this.nick = nick;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationData that = (RegistrationData) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (nick != null ? !nick.equals(that.nick) : that.nick != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }
}
