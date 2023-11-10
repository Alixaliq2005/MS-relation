package az.ingress.msrelation.configuration;

import org.springframework.security.core.Authentication;

public interface ClaimSetProvider {
    ClaimSet provideSet(Authentication authentication);
}
