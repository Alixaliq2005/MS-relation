package az.ingress.msrelation.repository;

import az.ingress.msrelation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
