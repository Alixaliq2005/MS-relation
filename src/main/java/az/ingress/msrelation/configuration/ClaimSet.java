package az.ingress.msrelation.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimSet {

    private String key;

    private Set<String> claim;
}
