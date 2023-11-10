package az.ingress.msrelation.repository.security;

import az.ingress.msrelation.domain.securityDomain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    @EntityGraph(attributePaths = {"authorities"})
    Optional<User> findByUserName(String UserName);
    User findById(long id);
}
