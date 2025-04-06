package com.pagos.backend.service.mapper;

import com.pagos.backend.dto.UserDto;
import com.pagos.backend.model.User;

public class UserMapper {
    public static UserDto toDTO(User user){
        if (user == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toEntity(UserDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
