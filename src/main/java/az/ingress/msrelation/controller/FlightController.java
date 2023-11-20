package az.ingress.msrelation.controller;

import az.ingress.msrelation.domain.Flight;
import az.ingress.msrelation.dto.request.FlightRequest;
import az.ingress.msrelation.dto.response.FlightResponse;
import az.ingress.msrelation.service.Impl.FlightServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightServiceImpl flightService;

    @GetMapping
    public ResponseEntity<List<FlightResponse>> findAll() {
        return new ResponseEntity<>(flightService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(flightService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/flighting")
    public ResponseEntity<FlightResponse> save(@RequestBody FlightRequest flightRequest){
        return new ResponseEntity<>(flightService.save(flightRequest),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> update(@PathVariable Long id, @RequestBody FlightRequest flightRequest){
        return new ResponseEntity<>(flightService.update(id,flightRequest),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        flightService.delete(id);
    }
}
