package az.ingress.msrelation.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@Getter
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private final CorsConfiguration cors = new CorsConfiguration();

    private final JwtProperties jwtProperties= new JwtProperties();


    @Getter
    @Setter
    public static class JwtProperties {

        private String secret;

        private long tokenValidInSeconds;

        private long refreshTokenValidInSeconds;

    }
}
