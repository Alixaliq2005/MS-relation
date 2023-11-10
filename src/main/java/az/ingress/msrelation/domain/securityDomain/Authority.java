package az.ingress.msrelation.domain.securityDomain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String Authority;

}
