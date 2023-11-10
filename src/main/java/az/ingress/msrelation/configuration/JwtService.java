package az.ingress.msrelation.configuration;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtService {
    private final Set<ClaimProvider> claimProviderSet;
    private final Set<ClaimSetProvider> claimSetProviders;
    private final SecurityProperties securityProperties;
    private Key key;

    public Claim parseToken(String token) {
        return Jwts.parser()
    }


    public String issueToken(Authentication authentication, Duration duration) {
        log.info("Issue JWt token for to {} for {}", authentication.getPrincipal(), duration);
        final JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus
                        (Duration.ofSeconds(securityProperties.getJwtProperties().getTokenValidInSeconds()))))
           
                
    }

}
