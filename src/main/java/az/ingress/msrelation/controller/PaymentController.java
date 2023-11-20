package az.ingress.msrelation.controller;

import az.ingress.msrelation.domain.Payment;
import az.ingress.msrelation.dto.request.PaymentRequest;
import az.ingress.msrelation.dto.response.PaymentResponse;
import az.ingress.msrelation.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;


    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(paymentService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> findAll(){
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentResponse> save(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.save(paymentRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@RequestBody PaymentRequest paymentRequest, @PathVariable Long paymentId){
        return new ResponseEntity<>(paymentService.update(paymentRequest, paymentId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long paymentId){
        paymentService.delete(paymentId);
    }
}
