package ua.sdo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sdo.model.payments.Payment;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("select u from Payment u where u.account.id = :id order by u.id ")
    List<Payment> findByAccountId(@Param("id") int id);

    @Query(value = "insert into credit_payments (account_id, 'sum', type_id) values(:idAcc, :money , :type_id, NOW())" , nativeQuery = true)
    void createPayment(@Param("idAcc") int idAcc, @Param("money") double money,@Param("type_id") int type_id);
}
