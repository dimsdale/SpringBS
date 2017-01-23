package ua.sdo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sdo.model.accounts.AccountStatus;
@Repository
public interface AccountStatusRepository extends JpaRepository<AccountStatus, Integer> {
}
