package az.ingress.msrelation.repository.security;

import az.ingress.msrelation.domain.securityDomain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Optional<Authority> findByAuthority(String authority);
}
