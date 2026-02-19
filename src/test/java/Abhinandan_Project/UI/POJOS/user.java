package Abhinandan_Project.UI.POJOS;

public class user {

    private String email_id;
    private String password;

    public user(String email_id, String password) {
        this.email_id = email_id;
        this.password = password;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{" +
                "email_id='" + email_id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
