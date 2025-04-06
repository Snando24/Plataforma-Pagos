package com.pagos.backend.service;

import com.pagos.backend.dto.UserDto;
import com.pagos.backend.model.User;
import com.pagos.backend.repository.UserRepository;
import com.pagos.backend.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Obtener todos los usuarios
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener usuario por ID
    public Optional<UserDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO);
    }

    // Crear un nuevo usuario
    public UserDto createUser(UserDto user) {
        User user1 = UserMapper.toEntity(user);
        User user2 = userRepository.save(user1);
        return UserMapper.toDTO(user2);
    }

    // Actualizar un usuario existente
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        });
    }

    // Eliminar un usuario
    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
