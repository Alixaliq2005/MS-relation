package az.ingress.msrelation.dto.request;

import az.ingress.msrelation.domain.Flights;
import az.ingress.msrelation.domain.Hotel;
import az.ingress.msrelation.domain.RentalCar;
import az.ingress.msrelation.dto.response.PaymentResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {
    String bookingDate;

    String totalCost;





}
