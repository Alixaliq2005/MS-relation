package az.ingress.msrelation.service;

import az.ingress.msrelation.domain.RentalCar;
import az.ingress.msrelation.dto.request.RentalCarRequest;
import az.ingress.msrelation.dto.response.RentalCarResponse;

import java.util.List;

public interface RentalCarService {
    List<RentalCarResponse> findAll();

    RentalCarResponse findById(Long id);

    RentalCarResponse save(RentalCarRequest carRequest);

    RentalCar update(Long id, RentalCarRequest carRequest);

    void delete(Long id);

}
