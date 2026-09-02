package com.api.suporte.dto;


import com.api.suporte.domain.User;

public record UserResponseDTO(Long id, String name, String email) {

    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}
