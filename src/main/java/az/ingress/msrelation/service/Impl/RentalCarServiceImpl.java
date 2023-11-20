package az.ingress.msrelation.service.Impl;

import az.ingress.msrelation.domain.RentalCar;
import az.ingress.msrelation.dto.request.RentalCarRequest;
import az.ingress.msrelation.dto.response.RentalCarResponse;
import az.ingress.msrelation.errors.ApplicationException;
import az.ingress.msrelation.errors.Errors;
import az.ingress.msrelation.repository.RentalCarRepository;
import az.ingress.msrelation.service.RentalCarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalCarServiceImpl implements RentalCarService {

    private final RentalCarRepository carRentalRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<RentalCarResponse> findAll() {
        return carRentalRepository
                .findAll()
                .stream()
                .map(rentalCar -> modelMapper.map(rentalCar, RentalCarResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public RentalCarResponse findById(Long id) {
        RentalCar car = carRentalRepository.findById(id).orElseThrow(() ->
                new ApplicationException(az.ingress.msrelation.errors.Errors.RENTAL_CAR_NOT_FOUND));
        return modelMapper.map(car, RentalCarResponse.class);
    }


    @Override
    public RentalCarResponse save(RentalCarRequest carRequest) {
        RentalCar car = modelMapper.map(carRequest, RentalCar.class);
        return modelMapper.map(carRentalRepository.save(car), RentalCarResponse.class);
    }

    @Override
    public RentalCar update(Long id, RentalCarRequest carRequest) {
        carRentalRepository.findById(id).orElseThrow(() -> new ApplicationException(az.ingress.msrelation.errors.Errors.RENTAL_CAR_NOT_FOUND));
        RentalCar responseCar = modelMapper.map(carRequest, RentalCar.class);
        responseCar.setId(id);
        return modelMapper.map(carRentalRepository.save(responseCar), RentalCar.class);
    }

    @Override
    public void delete(Long id) {
        RentalCar car = carRentalRepository.findById(id).orElseThrow(() ->
                new ApplicationException(Errors.RENTAL_CAR_NOT_FOUND));
        carRentalRepository.delete(car);
    }
}