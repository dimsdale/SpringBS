package ukr.dsa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import ukr.dsa.annotations.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Column(name = "name")
    @Size(min = 4, max = 50, message = "Size")
    @JsonProperty("name")
    @NotNull(message = "NotNull")
    private String name;

    @Column(name = "surname")
    @Size(min = 4, max = 50, message = "Size")
    @JsonProperty("surname")
    private String surname;

    @Column(name = "by_father_name")
    @Size(min = 4, max = 50, message = "Size")
    @JsonProperty("fatherName")
    private String byFatherName;

    @Column(name = "mobile_tel")
    @JsonProperty("mobileTel")
    @Phone(message = "Phone")
    @NotNull(message = "NotNull")
    private String mobileTel;

    @Column(name = "home_tel")
    @JsonProperty("homeTel")
    @Phone(message = "Phone")
    private String homeTel;

    @Column(name = "e_mail")
    @JsonProperty("e_mail")
    @Email(message = "Email")
    private String e_mail;

    @ManyToOne
    @JoinColumn(name = "user_login")
    @JsonProperty("user")
    private User user;

    public Contact() {
    }

    public Contact(String surname, String name, String byFatherName, String mobileTel, String homeTel, String e_mail, User user) {
        this.surname = surname;
        this.name = name;
        this.byFatherName = byFatherName;
        this.mobileTel = mobileTel;
        this.homeTel = homeTel;
        this.e_mail = e_mail;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getByFatherName() {
        return byFatherName;
    }

    public void setByFatherName(String byFatherName) {
        this.byFatherName = byFatherName;
    }

    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }

    public String getHomeTel() {
        return homeTel;
    }

    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Contact[" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", byFatherName='" + byFatherName + '\'' +
                ", mobileTel='" + mobileTel + '\'' +
                ", homeTel='" + homeTel + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", user=" + user +
                ']';
    }
}
