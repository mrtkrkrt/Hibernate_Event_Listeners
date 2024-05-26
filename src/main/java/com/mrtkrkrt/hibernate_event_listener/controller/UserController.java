package com.mrtkrkrt.hibernate_event_listener.controller;

import com.mrtkrkrt.hibernate_event_listener.dto.request.CreateUserRequest;
import com.mrtkrkrt.hibernate_event_listener.model.User;
import com.mrtkrkrt.hibernate_event_listener.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public void addUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.addUser(createUserRequest);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> retrieveUsers() {
        return ResponseEntity.ok(userService.retrieveUsers());
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody CreateUserRequest createUserRequest) {
        userService.updateUser(id, createUserRequest);
    }
}
