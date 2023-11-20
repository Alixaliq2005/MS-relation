package az.ingress.msrelation.repository;

import az.ingress.msrelation.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
