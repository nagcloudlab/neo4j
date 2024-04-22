package org.example.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserRequest {
    private String name;
    private String username;
    private String password;
    private String roles;
}
