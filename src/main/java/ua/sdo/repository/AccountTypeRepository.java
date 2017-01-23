package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sdo.model.accounts.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
}
