package az.ingress.msrelation.controller;

import az.ingress.msrelation.dto.request.UserRequest;
import az.ingress.msrelation.dto.response.UserResponse;
import az.ingress.msrelation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long userId, @PathVariable String id) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long userId, @RequestBody UserRequest userRequest, @PathVariable String id) {
        return new ResponseEntity<>(userService.update(userId, userRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long userId, @PathVariable String id) {
        userService.delete(userId);
    }
}
