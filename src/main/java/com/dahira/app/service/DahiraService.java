package com.dahira.app.service;

import com.dahira.app.dto.DahiraDto;
import com.dahira.app.dto.UserDto;
import com.dahira.app.entity.Dahira;
import com.dahira.app.entity.User;
import com.dahira.app.mapper.DahiraDtoMapper;
import com.dahira.app.mapper.UserDtoMapper;
import com.dahira.app.repository.DahiraRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class DahiraService {
    private final DahiraRepository dahiraRepository;
    private final DahiraDtoMapper dahiraDtoMapper;
    private final UserDtoMapper userDtoMapper;

    public DahiraDto addDahira(Dahira dahira){
        Dahira dahiraAdded = dahiraRepository.save(dahira);
        return dahiraDtoMapper.apply(dahiraAdded);
    }

    public List<DahiraDto> getAllDahira(){
        return dahiraRepository.findAll()
                .stream().map(dahiraDtoMapper).toList();
    }

    public DahiraDto getDahiraById(Long id) {
        return dahiraRepository.findById(id)
                .map(dahiraDtoMapper)
                .orElseThrow(() -> new RuntimeException("dahira introuvable"));
    }

    public DahiraDto updateDahira(Long  id, Dahira newDahira){
        Dahira dahiraExiting = dahiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dahira introuvable"));

        dahiraExiting.setName(newDahira.getName());
        dahiraExiting.setDescription(newDahira.getDescription());

        Dahira dahiraUdated = dahiraRepository.save(dahiraExiting);

        return dahiraDtoMapper.apply(dahiraUdated);
    }

    public List<UserDto> getUserByDahira(Long id) {
        Dahira dahira = dahiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dahira introuvable"));

        return dahira.getUsers().stream().map(userDtoMapper).toList();
    }

    public void deleteDahira(Long id){
        dahiraRepository.deleteById(id);
    }
}
