package org.example.service;


import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.dto.request.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserRequest request) {
        User user = new User();

        user.setName(request.getName());
        // TODO: make sure that this username doesn't exist.
        user.setUsername(request.getUsername());
        user.setRoles(request.getRoles());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Cypher query to create a new user

        // MATCH (u:User {username: $username})
        // WHERE NOT EXISTS(u)
        // CREATE (u:User {name: $name, username: $username, password: $password, roles: $roles})

        // or

        // MERGE (u:User {username: $username})
        // ON CREATE SET u.name = $name, u.password = $password, u.roles = $roles
        // RETURN u
        userRepository.save(user);

        return user;
    }
}