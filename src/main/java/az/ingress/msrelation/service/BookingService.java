package az.ingress.msrelation.service;

import az.ingress.msrelation.dto.request.BookingRequest;
import az.ingress.msrelation.dto.response.BookingResponse;

import java.util.List;

public interface BookingService {
    BookingResponse findById1(Long id);

    List<BookingResponse> findAll();

    BookingResponse save(Long userId, Long paymentId, BookingRequest bookingRequest);

    void delete(Long id);
}
