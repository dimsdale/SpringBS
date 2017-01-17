package ua.sdo.model.users;

import ua.sdo.model.users.enums.UserType;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Inheritance
@Entity
public abstract class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @Column(name = "login", unique = true)
    @Size(min = 4, max = 50)
    protected String login;

    @Column(name = "password")
    @Size(min = 4, max = 50)
    protected String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    protected UserType userType;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
