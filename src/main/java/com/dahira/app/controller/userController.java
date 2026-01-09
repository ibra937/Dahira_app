package com.dahira.app.controller;

import com.dahira.app.dto.UserDto;
import com.dahira.app.entity.User;
import com.dahira.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class userController {
    private final UserService userService;

    @PostMapping("/new")
    public UserDto createUser(@RequestBody User user) {
        return userService.newUser(user);
    }

    @GetMapping("/all")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/id/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/email/{username}")
    public UserDto findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PutMapping("/{id}/update")
    public UserDto updateUser(@PathVariable Long id ,@RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
