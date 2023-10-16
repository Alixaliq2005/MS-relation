package az.ingress.msrelation.dto.response;

import az.ingress.msrelation.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {
    Long paymentId;

    String paymentAmount;

    String paymentDate;

    String paymentMethod;
    Booking booking;
}
