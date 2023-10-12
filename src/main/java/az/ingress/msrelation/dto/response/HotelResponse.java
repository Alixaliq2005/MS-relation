package az.ingress.msrelation.dto.response;

import az.ingress.msrelation.domain.Booking;
import az.ingress.msrelation.domain.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponse {
    Long id;

    String hotelName;

    String location;

    RoomType roomType;

    Double price;

    Booking booking;

}
