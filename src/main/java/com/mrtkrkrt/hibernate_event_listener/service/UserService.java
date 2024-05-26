package com.mrtkrkrt.hibernate_event_listener.service;

import com.mrtkrkrt.hibernate_event_listener.dto.request.CreateUserRequest;
import com.mrtkrkrt.hibernate_event_listener.model.User;
import com.mrtkrkrt.hibernate_event_listener.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addUser(CreateUserRequest createUserRequest) {
        User user = User.builder().username(createUserRequest.getUsername()).password(createUserRequest.getPassword()).build();
        userRepository.save(user);
    }

    public List<User> retrieveUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(Long id, CreateUserRequest createUserRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(createUserRequest.getPassword());
        userRepository.save(user);
    }
}
