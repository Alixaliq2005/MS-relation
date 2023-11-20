package az.ingress.msrelation.service.Impl;

import az.ingress.msrelation.domain.Flight;
import az.ingress.msrelation.dto.request.FlightRequest;
import az.ingress.msrelation.dto.response.FlightResponse;
import az.ingress.msrelation.errors.ApplicationException;
import az.ingress.msrelation.errors.Errors;
import az.ingress.msrelation.repository.BookingRepository;
import az.ingress.msrelation.repository.FlightRepository;
import az.ingress.msrelation.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;
    private final BookingRepository bookingRepository;

    @Override
    public List<FlightResponse> findAll() {
        return flightRepository
                .findAll()
                .stream()
                .map(flight -> modelMapper.map(flight, FlightResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public FlightResponse findById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(Errors.FLIGHT_NOT_FOUND));
        return modelMapper.map(flight, FlightResponse.class);
    }

    public FlightResponse save(FlightRequest flightRequest){
        Flight flight = modelMapper.map(flightRequest, Flight.class);
        return modelMapper.map(flightRepository.save(flight), FlightResponse.class);
    }

    @Override
    public Flight update(Long id, FlightRequest flightRequest) {
        flightRepository.findById(id).orElseThrow(() -> new ApplicationException(Errors.FLIGHT_NOT_FOUND));
        Flight responseFlight = modelMapper.map(flightRequest, Flight.class);
        responseFlight.setId(id);
        return modelMapper.map(flightRepository.save(responseFlight), Flight.class);
    }

    @Override
    public void delete(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() ->
                new ApplicationException(Errors.FLIGHT_NOT_FOUND));
        flightRepository.delete(flight);
    }



}
