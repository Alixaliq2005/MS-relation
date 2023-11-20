package az.ingress.msrelation.service;

import az.ingress.msrelation.domain.Hotel;
import az.ingress.msrelation.dto.request.HotelRequest;
import az.ingress.msrelation.dto.response.HotelResponse;

import java.util.List;

public interface HotelService {
    HotelResponse findById(Long id);

    List<HotelResponse> findAll();

    HotelResponse save(HotelRequest hotelRequest);

    Hotel update(Long id, HotelRequest hotelRequest);

    void delete(Long id);

}
