package ua.sdo.model.accounts;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DepositAccount")
public class DepositAccount extends Account {

    public DepositAccount() {
        this.percentage = 5;
    }
}
