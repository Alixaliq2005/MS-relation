package az.ingress.msrelation.dto.request;

import az.ingress.msrelation.domain.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelRequest {
    String hotelName;

    String location;

    RoomType roomType;

    Double price;
}
