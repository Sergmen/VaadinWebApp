package com.haulmont.testtask.Entities;

import javax.persistence.*;

@Entity(name = "Organisation")
@Table(name = "organisation")
@Data
public class DoctorImpl {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "organisation", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<VacancyImpl> vacancies = new HashSet();

}


