package ua.sdo.model.accounts;

import ua.sdo.model.payments.Payment;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@DiscriminatorValue("CreditAccount")
public class CreditAccount extends Account {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Set<Payment> payments;

//    public CreditAccount() {
//        this.percentage = 7;
//    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

}
