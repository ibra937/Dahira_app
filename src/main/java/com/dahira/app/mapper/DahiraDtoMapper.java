package com.dahira.app.mapper;

import com.dahira.app.dto.DahiraDto;
import com.dahira.app.entity.Dahira;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DahiraDtoMapper implements Function<Dahira, DahiraDto> {
    @Override
    public DahiraDto apply(Dahira dahira) {
        return new DahiraDto(
                dahira.getId(),
                dahira.getName(),
                dahira.getDescription()
        );
    }
}
