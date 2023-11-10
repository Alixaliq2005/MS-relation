package az.ingress.msrelation.configuration;

import org.springframework.security.core.Authentication;

public interface ClaimProvider {
    Claim provide(Authentication authentication);
}
