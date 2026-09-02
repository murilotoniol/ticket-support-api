package com.api.suporte.service;

import com.api.suporte.domain.User;
import com.api.suporte.dto.UserRequestDTO;
import com.api.suporte.dto.UserResponseDTO;
import com.api.suporte.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Transactional
    public UserResponseDTO addUser(UserRequestDTO dto){
        User user = new User(dto.name(), dto.email());

//        if(userRepository.existsByEmail(dto.email()){
//            throw new EmailAlreadyExistsException("Email já cadastrado!");
//        }

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(savedUser);
    }
}
