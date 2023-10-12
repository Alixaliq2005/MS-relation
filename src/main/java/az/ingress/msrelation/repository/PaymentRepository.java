package az.ingress.msrelation.repository;

import az.ingress.msrelation.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
