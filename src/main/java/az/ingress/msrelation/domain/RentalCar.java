package az.ingress.msrelation.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Entity
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "rental_car")
public class RentalCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String rentalCompany;

    String carModel;

    String rentalPeriod;

    Double price;

    String pickUpLocation;

    String dropOfLocation;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Booking booking;
}
