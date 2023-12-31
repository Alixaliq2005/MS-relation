package az.ingress.msrelation.service.Impl;

import az.ingress.msrelation.domain.Payment;
import az.ingress.msrelation.dto.request.PaymentRequest;
import az.ingress.msrelation.dto.response.PaymentResponse;
import az.ingress.msrelation.errors.ApplicationException;
import az.ingress.msrelation.errors.Errors;
import az.ingress.msrelation.repository.PaymentRepository;
import az.ingress.msrelation.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final ModelMapper modelMapper;

    @Override
    public PaymentResponse findById(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() ->
                new ApplicationException(Errors.PAYMENT_NOT_FOUND));
        return modelMapper.map(payment, PaymentResponse.class);
    }

    @Override
    public List<PaymentResponse> findAll() {
        return paymentRepository
                .findAll()
                .stream()
                .map(payment -> modelMapper.map(payment, PaymentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponse save(PaymentRequest paymentRequest) {
        Payment payment = modelMapper.map(paymentRequest, Payment.class);
        return modelMapper.map(paymentRepository.save(payment), PaymentResponse.class);
    }

    @Override
    public Payment update(PaymentRequest paymentRequest, Long paymentId) {
        paymentRepository.findById(paymentId).orElseThrow(() -> new ApplicationException(Errors.PAYMENT_NOT_FOUND));
        Payment responsePayment = modelMapper.map(paymentRequest, Payment.class);
        responsePayment.setPaymentId(paymentId);
        return modelMapper.map(paymentRepository.save(responsePayment), Payment.class);
    }

    @Override
    public void delete(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() ->
                new ApplicationException(Errors.PAYMENT_NOT_FOUND));
        paymentRepository.delete(payment);
    }
}
