package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sdo.model.CreditPayment;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<CreditPayment, Integer> {

    @Query("select u from CreditPayment u where u.account.id = :id order by u.id ")
    List<CreditPayment> findByAccountId(@Param("id") int id);
}
