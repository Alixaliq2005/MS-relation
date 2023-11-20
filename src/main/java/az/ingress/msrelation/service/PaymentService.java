package az.ingress.msrelation.service;

import az.ingress.msrelation.domain.Payment;
import az.ingress.msrelation.dto.request.PaymentRequest;
import az.ingress.msrelation.dto.response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    PaymentResponse findById(Long paymentId);

    List<PaymentResponse> findAll();

    PaymentResponse save(PaymentRequest paymentRequest);

    Payment update(PaymentRequest paymentRequest, Long paymentId);

    void delete(Long paymentId);

}
