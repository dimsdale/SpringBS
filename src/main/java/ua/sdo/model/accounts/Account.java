package ua.sdo.model.accounts;

import org.hibernate.annotations.Type;
import ua.sdo.model.accounts.enums.AccountStatus;
import ua.sdo.model.accounts.enums.AccountType;
import ua.sdo.model.users.User;

import javax.persistence.*;
import java.util.Date;

@Inheritance
@Entity
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @Column(name = "Sum", nullable = false)
    protected volatile double sum;

    @Column(name = "date_of_open")
    @Type(type = "timestamp")
    protected Date date_of_open;

    @Column(name = "percentage", nullable = false)
    protected int percentage;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    protected AccountStatus accountStatus;

    @Column(name = "date_close")
    @Type(type = "date")
    protected Date date_of_close;

    @Enumerated(EnumType.STRING)
    @Column(name = "accountType")
    protected AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected User user;

    public Account() {

    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDate_of_open() {
        return date_of_open;
    }

    public void setDate_of_open(Date date_of_open) {
        this.date_of_open = date_of_open;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getDate_of_close() {
        return date_of_close;
    }

    public void setDate_of_close(Date date_of_close) {
        this.date_of_close = date_of_close;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
