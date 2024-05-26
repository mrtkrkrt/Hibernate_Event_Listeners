package com.mrtkrkrt.hibernate_event_listener.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequest {
    private String username;
    private String password;
}
