package com.mrtkrkrt.hibernate_event_listener.repository;

import com.mrtkrkrt.hibernate_event_listener.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
