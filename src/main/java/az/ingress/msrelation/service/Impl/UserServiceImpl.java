package az.ingress.msrelation.service.Impl;

import az.ingress.msrelation.domain.User;
import az.ingress.msrelation.dto.request.UserRequest;
import az.ingress.msrelation.dto.response.UserResponse;
import az.ingress.msrelation.repository.UserRepository;
import az.ingress.msrelation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserResponse> findAll() {
        return (List<UserResponse>) userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }


    @Override
    public UserResponse findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                String.format("User not found by id -%s" + userId)
        ));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse update(Long userId, UserRequest userRequest) {
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                String.format("User not found for updating by id -%s" +userId)
        ));
        User user = modelMapper.map(userRequest, User.class);
        user.setUserId(userId);
        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }

    @Override
    public void delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                String.format("User not found for deleting by id -%s" + userId)
        ));
        userRepository.delete(user);
    }


}
