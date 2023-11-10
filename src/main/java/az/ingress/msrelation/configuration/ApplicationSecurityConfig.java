package az.ingress.msrelation.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface ApplicationSecurityConfig {
    void configure(HttpSecurity httpSecurity) throws Exception;
}
