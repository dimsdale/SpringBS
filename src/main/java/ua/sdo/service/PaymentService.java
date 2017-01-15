package ua.sdo.service;

import ua.sdo.model.CreditPayment;

import java.util.List;

public interface PaymentService {
    List<CreditPayment> findByAccountId(int id);
}
