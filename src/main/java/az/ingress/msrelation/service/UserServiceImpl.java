package az.ingress.msrelation.service;

import az.ingress.msrelation.domain.User;
import az.ingress.msrelation.dto.request.UserRequest;
import az.ingress.msrelation.dto.response.UserResponse;
import az.ingress.msrelation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserResponse> findAll() {
        return (List<UserResponse>) userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user,UserResponse.class))
                .collect(Collectors.toList());
    }

    public UserResponse saveUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }


    public UserResponse findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("User not found by id -%s"+ id)
        ));
        return modelMapper.map(user,UserResponse.class);
    }
}
