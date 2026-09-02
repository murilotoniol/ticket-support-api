package com.api.suporte.controller;

import com.api.suporte.domain.User;
import com.api.suporte.dto.UserResponseDTO;
import com.api.suporte.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> users = userService.getAll()
                .stream()
                .map(UserResponseDTO::new)
                .toList();

        return ResponseEntity.ok(users);
    }
}
