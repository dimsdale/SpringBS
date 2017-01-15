package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sdo.model.accounts.Account;
import ua.sdo.model.accounts.enums.AccountStatus;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("select c from Account c where c.user.login = :login order by c.id")
    List<Account> findByLogin(@Param("login") String login);

    @Modifying
    @Query("update Account a set a.sum = a.sum - :money  where a.id = :id")
    void updateSumAccount(@Param("money") double money, @Param("id") int id);

    @Modifying
    @Query("update Account a set a.date_of_close = current_timestamp , a.accountStatus = :accountStatus, a.sum = 0 where a.id = :id and a.sum = 0")
    void closeAccount(@Param("accountStatus") AccountStatus accountStatus, @Param("id") int id);
}
