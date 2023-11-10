package az.ingress.msrelation.domain.securityDomain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String role;

    private String password;

    private LocalDate creationDate;

    private boolean AccountNonExpired;

    private boolean AccountNonLocked;

    private boolean CredentialsNonExpired;

    private boolean Enabled;

    private String mobilePassword;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_authorities",
    joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="authorities_id",referencedColumnName = "id")})
    private Set<Authority> authorities =new HashSet<>();
}