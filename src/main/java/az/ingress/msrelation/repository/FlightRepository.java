package az.ingress.msrelation.repository;

import az.ingress.msrelation.domain.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flights,Long> {
}
