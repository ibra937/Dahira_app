package com.dahira.app.controller;

import com.dahira.app.dto.DahiraDto;
import com.dahira.app.dto.UserDto;
import com.dahira.app.entity.Dahira;
import com.dahira.app.service.DahiraService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dahiras")
@RequiredArgsConstructor
@Data
public class DahiraController {
    private final DahiraService dahiraService;

    @PostMapping("/new")
    public DahiraDto newDahira(@RequestBody Dahira dahira) {
        return dahiraService.addDahira(dahira);
    }

    @PutMapping("/{id}/update")
    public DahiraDto updateDahira(@PathVariable Long id, @RequestBody Dahira dahira) {
        return dahiraService.updateDahira(id, dahira);
    }

    @GetMapping("/all")
    public List<DahiraDto> getAll() {
        return dahiraService.getAllDahira();
    }

    @GetMapping("/id/{id}")
    public DahiraDto getDahira(@PathVariable Long id) {
        return dahiraService.getDahiraById(id);
    }

    @GetMapping("/{id}/users")
    public List<UserDto> getUserDahira(@PathVariable Long id) {
        return dahiraService.getUserByDahira(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDahira(@PathVariable Long id) {
        dahiraService.deleteDahira(id);
    }
}
