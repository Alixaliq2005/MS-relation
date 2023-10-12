package az.ingress.msrelation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String bookingDate;
    String totalCost;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    User user;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @Builder.Default
    List <Flights> flights = new ArrayList<>();

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @Builder.Default
    List <RentalCar> rentAlCars = new ArrayList<>();

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @Builder.Default
    List <Hotel> hotels = new ArrayList<>();

    @OneToOne
    @JsonIgnore
    @JoinColumn(name="payment_id")
    @ToString.Exclude
    Payment payment;



}
