package DBandSession;

/**
 *
 * @author dsp
 */

public class User {

    private int id;
    private String fullName, gender, email, dateofbirth, password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public User(String fullName, String gender, String email, String password, String dateofbirth) {
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.dateofbirth = dateofbirth.toString();
        this.password = password;
    }
}
