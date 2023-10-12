package az.ingress.msrelation.repository;

import az.ingress.msrelation.domain.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCarRepository extends JpaRepository<RentalCar,Long> {
}
