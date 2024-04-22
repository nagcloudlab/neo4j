package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.model.User;
import org.example.dto.request.CreateUserRequest;
import org.example.service.NeoUserDetailsService;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;
    private final NeoUserDetailsService neoUserDetailsService;

    @GetMapping("/me")
    public String me(Principal principal) {
      return principal.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> signUp(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request);
        UserDTO responseUser = new UserDTO(user.getName(), user.getUsername(), user.getRoles());
        return new ResponseEntity<>(responseUser, HttpStatus.CREATED);
    }

}
