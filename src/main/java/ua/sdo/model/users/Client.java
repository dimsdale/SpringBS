package ua.sdo.model.users;

import ua.sdo.model.accounts.Account;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@DiscriminatorValue("Client")
public class Client extends User {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Account> accounts;

    public Client() {
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

}
