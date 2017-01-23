package ua.sdo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.sdo.model.payments.TypePayment;
@Repository
public interface TypePaymentRepository extends JpaRepository<TypePayment, Integer> {
}
