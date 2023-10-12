package az.ingress.msrelation.repository;

import az.ingress.msrelation.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
