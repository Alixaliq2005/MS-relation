package az.ingress.msrelation.controller;

import az.ingress.msrelation.dto.request.UserRequest;
import az.ingress.msrelation.dto.response.UserResponse;
import az.ingress.msrelation.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll(){
        return new ResponseEntity<>(userServiceImpl.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<UserResponse> save (@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userServiceImpl.saveUser(userRequest), HttpStatus.CREATED);
    }
    @GetMapping("/id")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(userServiceImpl.findById(id), HttpStatus.OK);
    }
}
