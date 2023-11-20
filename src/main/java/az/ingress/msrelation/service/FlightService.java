package az.ingress.msrelation.service;

import az.ingress.msrelation.domain.Flight;
import az.ingress.msrelation.dto.request.FlightRequest;
import az.ingress.msrelation.dto.response.FlightResponse;

import java.util.List;

public interface FlightService {
    List<FlightResponse> findAll();

    FlightResponse findById(Long id);

    Flight update(Long id, FlightRequest flightRequest);

    void delete(Long id);
}
