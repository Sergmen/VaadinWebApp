package com.haulmont.testtask.Entities;

import javax.persistence.*;

@Entity(name = "Vacancy")
@Table(name = "vacancy")
@Data
public class RecipeImpl {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private String position;


    @ManyToMany
    @JoinTable(name = "vacancies_candidates",
            joinColumns = @JoinColumn(name = "vacancy_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private Set<CandidateImpl> candidates = new HashSet<>();
}

