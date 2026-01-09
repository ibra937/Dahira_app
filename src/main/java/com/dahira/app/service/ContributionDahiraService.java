package com.dahira.app.service;

import com.dahira.app.entity.ContributionDahira;
import com.dahira.app.repository.ContributionDahiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContributionDahiraService {
    private final ContributionDahiraRepository contributionDahiraRepository;

    public ContributionDahira createContributionDahira(ContributionDahira contributionDahira) {
        return contributionDahiraRepository.save(contributionDahira);
    }

    public List<ContributionDahira> getAllContributionsDahira() {
        return contributionDahiraRepository.findAll();
    }

    public ContributionDahira updateContributionDahira(ContributionDahira contributionDahira) {
        return contributionDahiraRepository.save(contributionDahira);
    }

    public  void deleteContributionDahira(Long id) {
        contributionDahiraRepository.deleteById(id);
    }
}
