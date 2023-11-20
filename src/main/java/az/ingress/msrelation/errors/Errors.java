package az.ingress.msrelation.errors;

import org.springframework.http.HttpStatus;

public enum Errors implements ErrorResponse {
    jakarta_NOT_NULL("jakarta.validation.constraints.notNull.message",
            HttpStatus.BAD_REQUEST, "value is not be empty"),
    BOOKING_NOT_FOUND("BOOKING_NOT_FOUND",
            HttpStatus.NO_CONTENT, "booking not found"),
    FLIGHT_NOT_FOUND("FLIGHT_NOT_FOUND",
            HttpStatus.NO_CONTENT, "flight not found"),
    HOTEL_NOT_FOUND("HOTEL_NOT_FOUND",
            HttpStatus.NO_CONTENT, "hotel not found"),
    PAYMENT_NOT_FOUND("PAYMENT_NOT_FOUND",
            HttpStatus.NO_CONTENT, "payment not found"),
    RENTAL_CAR_NOT_FOUND("RENTAL_CAR_NOT_FOUND",
            HttpStatus.NO_CONTENT, "rentalCar not found"),
    USER_NOT_FOUND("USER_NOT_FOUND",
            HttpStatus.NO_CONTENT, "user not found");

    String key;
    String httpStatus;
    String message;

    Errors(String key, HttpStatus httpStatus, String message) {
        this.message = message;
        this.key = key;
        this.httpStatus = String.valueOf(httpStatus);
    }

    @Override
    public java.lang.String getKey() {
        return key;
    }

    @Override
    public java.lang.String getMessage() {
        return message;
    }

    @Override
    public java.lang.String getHttpStatus() {
        return httpStatus;
    }


}
