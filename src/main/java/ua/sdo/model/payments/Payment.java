package ua.sdo.model.payments;

import org.hibernate.annotations.Type;
import ua.sdo.model.accounts.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit_payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "sum", nullable = false)
    private double sum;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypePayment type;

    @Column(name = "date_of_payment")
    @Type(type = "timestamp")
    private Date date_of_payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Date getDate_of_payment() {
        return date_of_payment;
    }

    public void setDate_of_payment(Date date_of_payment) {
        this.date_of_payment = date_of_payment;
    }

    public TypePayment getType() {
        return type;
    }

    public void setType(TypePayment type) {
        this.type = type;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
