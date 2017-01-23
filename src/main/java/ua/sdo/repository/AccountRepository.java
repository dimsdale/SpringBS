package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sdo.model.accounts.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("select c from Account c where c.user.login = :login")
    List<Account> findByLogin(@Param("login") String login);

    @Query("select c from Account c where c.user.id = :id")
    List<Account> findById(@Param("id") int id);

    @Modifying
    @Query("update Account a set a.sum = a.sum - :money  where a.id = :id")
    void updateSumAccount(@Param("money") double money, @Param("id") int id);

    @Modifying
    @Query("update Account a set a.date_of_close = current_timestamp , a.accountStatus.id = 2, a.sum = 0 where a.id = :id and a.sum = 0")
    void closeAccount(@Param("id") int id);
}
