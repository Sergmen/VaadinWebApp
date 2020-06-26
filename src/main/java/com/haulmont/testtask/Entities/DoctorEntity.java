package com.haulmont.testtask.Entities;

import lombok.*;
import lombok.Builder;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "Doctor")
@Table(name = "doctor")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "specialization", nullable = true)
    private String specialization;

    @OneToMany(mappedBy = "doctor")
    private Set<RecipeEntity> recipes = new HashSet<>();

}


