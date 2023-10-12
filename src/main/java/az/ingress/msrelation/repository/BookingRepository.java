package az.ingress.msrelation.repository;

import az.ingress.msrelation.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
