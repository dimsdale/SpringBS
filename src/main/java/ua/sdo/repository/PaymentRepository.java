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

    @Query(value = "insert into credit_payments (account_id, 'sum', payment_type, date_of_payment) values(:id, :payment.sum, :payment.payment_type, now())" , nativeQuery = true)
    void createPayment(@Param("id") int id, @Param("payment") Payment payment);
}
