package az.ingress.msrelation.dto.response;

import az.ingress.msrelation.domain.Flight;
import az.ingress.msrelation.domain.Hotel;
import az.ingress.msrelation.domain.RentalCar;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {
    Long id;

    String bookingDate;

    String totalCost;

    List<Flight> flights;

    List<RentalCar> rentAlCars;

    List<Hotel> hotels;
    PaymentResponse payment;
}
