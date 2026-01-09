package com.dahira.app.controller;

import com.dahira.app.entity.ContributionDahira;
import com.dahira.app.service.ContributionDahiraService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributions")
@Data
@RequiredArgsConstructor
public class ContributionDahiraController {
    private final ContributionDahiraService contributionDahiraService;

    @PostMapping("/new")
    public ContributionDahira newContributionDahira(ContributionDahira contributionDahira) {
        return contributionDahiraService.createContributionDahira(contributionDahira);
    }

    @GetMapping("/all")
    public List<ContributionDahira> getAll() {
        return contributionDahiraService.getAllContributionsDahira();
    }

    @PutMapping
    public ContributionDahira updateContributionDahira(ContributionDahira contributionDahira) {
        return contributionDahiraService.updateContributionDahira(contributionDahira);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContributionDahira(@PathVariable Long id) {
        contributionDahiraService.deleteContributionDahira(id);
    }
}
