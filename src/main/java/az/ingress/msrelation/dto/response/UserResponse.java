package az.ingress.msrelation.dto.response;

import az.ingress.msrelation.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long userId;

    String name;

    String surname;

    String email;

    String phoneNumber;

    List<BookingResponse> bookings;
}
