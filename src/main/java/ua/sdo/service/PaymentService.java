package ua.sdo.service;

import ua.sdo.model.payments.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findByAccountId(int id);
    void addPay(Payment payment);
    void createPayment(int id, Payment payment);
}
