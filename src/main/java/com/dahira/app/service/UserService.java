package com.dahira.app.service;

import com.dahira.app.dto.UserDto;
import com.dahira.app.entity.Role;
import com.dahira.app.entity.User;
import com.dahira.app.mapper.UserDtoMapper;
import com.dahira.app.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;
    public UserDto newUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("L'email est deja lie a un compte !");
        }
        if (userRepository.findByNumberPhone(user.getNumberPhone()).isPresent()) {
            throw new RuntimeException("Ce numero de telephone est deja lie a un compte");
        }
        user.setRole(Role.USER);
        User userAdded = userRepository.save(user);
        return userDtoMapper.apply(userAdded);
    }

    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream().map(userDtoMapper).toList();
    }

    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userDtoMapper)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public UserDto findByUsername(String email) {
        return userRepository.findByEmail(email)
                .map(userDtoMapper)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + email));
    }

    public UserDto updateUser(Long id, User updatedUserData) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec l'id : " + id));

        existingUser.setIdentityPiece(updatedUserData.getIdentityPiece());
        existingUser.setFirstName(updatedUserData.getFirstName());
        existingUser.setLastName(updatedUserData.getLastName());
        existingUser.setEmail(updatedUserData.getEmail());
        existingUser.setProfession(updatedUserData.getProfession());
        existingUser.setNumberPhone(updatedUserData.getNumberPhone());
        existingUser.setPassword(updatedUserData.getPassword());
        existingUser.setDahira(updatedUserData.getDahira());
        existingUser.setRole(updatedUserData.getRole());

        User savedUser = userRepository.save(existingUser);
        return userDtoMapper.apply(savedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
