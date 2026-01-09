package com.dahira.app.dto;

import com.dahira.app.entity.Role;

public record UserDto (
        Long id,
        Long identityPiece,
        String firstName,
        String lastName,
        String email,
        String profession,
        String numberPhone,
        String dahira,
        Role role
) {}
