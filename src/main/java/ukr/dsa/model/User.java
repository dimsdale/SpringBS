package ukr.dsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import ukr.dsa.annotations.FieldEquals;
import ukr.dsa.annotations.Unique;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
@FieldEquals(field = "password", equalsTo = "confirmPassword")
public class User implements Serializable {

    @Id
    @Column(name = "login", unique = true)
    @Size(min = 3, max = 50)
    @JsonProperty("login")
    @NotNull
    @Unique(message = "NotUnique")
    private String login;

    @Column(name = "fio")
    @Size(min = 5, max = 100)
    @JsonProperty("fio")
    @NotNull
    private String fio;

    @Column(name = "password")
    @JsonProperty("password")
    @Size(min = 4, max = 100)
    @NotNull
    private String password;

    @NotNull
    @JsonIgnore
    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<Contact> cellBook = new ArrayList<Contact>();
    public User() {
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Contact> getCellBook() {
        return cellBook;
    }

    public void setCellBook(List<Contact> cellBook) {
        this.cellBook = cellBook;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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

    @Override
    public String toString() {
        return "User[login: " + login + ", password: " + password + ", fio: " + fio + "]";
    }
}
