package com.haulmont.testtask.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Patient")
@Table(name = "patient")
@Data
public class PatientImpl {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(mappedBy = "candidates")
    private List<VacancyImpl> vacancies = new ArrayList<>();

}

















