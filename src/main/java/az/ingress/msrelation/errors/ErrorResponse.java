package az.ingress.msrelation.errors;

public interface ErrorResponse {
    String getKey();

    String getMessage();

    String getHttpStatus();
}
