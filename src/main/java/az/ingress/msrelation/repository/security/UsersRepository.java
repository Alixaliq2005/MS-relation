package az.ingress.msrelation.repository.security;

import az.ingress.msrelation.domain.securityDomain.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long>, JpaSpecificationExecutor<Users> {
    @EntityGraph(attributePaths = {"authorities"})
    Optional<Users> findByUsername(String Username);
    Users findById(long id);
}
