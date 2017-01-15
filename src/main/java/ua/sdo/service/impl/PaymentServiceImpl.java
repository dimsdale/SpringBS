package ua.sdo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sdo.model.CreditPayment;
import ua.sdo.repository.PaymentRepository;
import ua.sdo.service.PaymentService;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<CreditPayment> findByAccountId(int id) {
        return paymentRepository.findByAccountId(id);
    }
}
