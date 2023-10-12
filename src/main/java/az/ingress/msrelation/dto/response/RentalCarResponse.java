package az.ingress.msrelation.dto.response;

import az.ingress.msrelation.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentalCarResponse {
    Long id;

    String rentalCompany;

    String carModel;

    String rentalPeriod;

    Double price;

    String pickUpLocation;

    String dropOfLocation;

    Booking booking;
}
