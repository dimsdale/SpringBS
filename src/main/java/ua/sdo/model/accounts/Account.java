package ua.sdo.model.accounts;

import org.hibernate.annotations.Type;
import ua.sdo.model.payments.Payment;
import ua.sdo.model.users.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "Sum", nullable = false)
    private volatile double sum;

    @Column(name = "date_of_open")
    @Type(type = "timestamp")
    private Date date_of_open;

    @Column(name = "term_of_credit")
    private int term_of_credit;

    @Column(name = "everymonth_payment")
    private double everymonthPayment;

    @Column(name = "percentage", nullable = false)
    private int percentage;

    @ManyToOne
    @JoinColumn(name = "account_status_id")
    private AccountStatus accountStatus;

    @Column(name = "date_close")
    @Type(type = "date")
    private Date date_of_close;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<Payment> payments;

    public int getTerm_of_credit() {
        return term_of_credit;
    }

    public void setTerm_of_credit(int term_of_credit) {
        this.term_of_credit = term_of_credit;
    }

    public double getEverymonthPayment() {
        return everymonthPayment;
    }

    public void setEverymonthPayment(double everymonthPayment) {
        this.everymonthPayment = everymonthPayment;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

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
