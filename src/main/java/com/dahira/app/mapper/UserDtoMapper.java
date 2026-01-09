package com.dahira.app.mapper;

import com.dahira.app.dto.UserDto;
import com.dahira.app.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDtoMapper implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user){
        String dahiraName = user.getDahira() != null ? user.getDahira().getName() : null;
        return new UserDto(
                user.getId(),
                user.getIdentityPiece(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getProfession(),
                user.getNumberPhone(),
                dahiraName,
                user.getRole()
        );
    }
}
