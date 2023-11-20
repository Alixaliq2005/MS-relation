package az.ingress.msrelation.service.Impl;

import az.ingress.msrelation.domain.Booking;
import az.ingress.msrelation.domain.Payment;
import az.ingress.msrelation.domain.User;
import az.ingress.msrelation.dto.request.BookingRequest;
import az.ingress.msrelation.dto.response.BookingResponse;
import az.ingress.msrelation.errors.ApplicationException;
import az.ingress.msrelation.errors.Errors;
import az.ingress.msrelation.repository.BookingRepository;
import az.ingress.msrelation.repository.PaymentRepository;
import az.ingress.msrelation.repository.UserRepository;
import az.ingress.msrelation.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public List<BookingResponse> findAll() {
        return (List<BookingResponse>) bookingRepository
                .findAll()
                .stream()
                .map(booking -> modelMapper.map(booking, BookingResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponse findById1(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() ->
                new ApplicationException(Errors.BOOKING_NOT_FOUND));
        BookingResponse bookingResponse = modelMapper.map(booking, BookingResponse.class);
        return bookingResponse;
    }

    @Override
    public BookingResponse save(Long userId, Long paymentId, BookingRequest bookingRequest) {
        User user = getUserById(userId);
        Payment payment = getPaymentByID(paymentId);
        Booking booking = createBooking(user, payment, bookingRequest);
        return mapToBookingResponse(booking);
    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                String.format("User not found by id -%s" + userId)
        ));
    }

    private Payment getPaymentByID(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException(
                String.format("Payment not found by id -%s" + paymentId)
        ));
    }

    private Booking createBooking(User user, Payment payment, BookingRequest bookingRequest) {
        Booking booking = modelMapper.map(bookingRequest, Booking.class);
        booking.setUser(user);
        booking.setPayment(payment);
        return bookingRepository.save(booking);
    }

    private BookingResponse mapToBookingResponse(Booking booking) {
        return modelMapper.map(booking, BookingResponse.class);
    }

    @Override
    public void delete(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Booking not found by id -%s" + id)
        ));
        bookingRepository.delete(booking);
    }


}

