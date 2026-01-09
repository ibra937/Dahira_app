package com.dahira.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long identityPiece;
    private String firstName;
    private String lastName;
    private String email;
    private String profession;
    private String numberPhone;
    private  String password;

    @ManyToOne
    private Dahira dahira;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ContributionMembre> contributionsMembres;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @Enumerated(EnumType.STRING)
    private Role role;
}
