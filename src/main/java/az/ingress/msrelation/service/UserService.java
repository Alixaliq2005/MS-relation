package az.ingress.msrelation.service;

import az.ingress.msrelation.dto.request.UserRequest;
import az.ingress.msrelation.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAll();

    UserResponse saveUser(UserRequest userRequest);

    UserResponse findById(Long userId);

    UserResponse update(Long userId, UserRequest userRequest);

    void delete(Long userId);
}
