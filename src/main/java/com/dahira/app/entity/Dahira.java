package com.dahira.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dahira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "dahira", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "dahira", cascade = CascadeType.ALL)
    private List<ContributionDahira> contributionsGlobales;
}
