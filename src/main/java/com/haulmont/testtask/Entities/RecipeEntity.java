package com.haulmont.testtask.Entities;

import com.haulmont.testtask.common.Priority;
import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "Recipe")
@Table(name = "recipe")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(targetEntity = PatientEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private PatientEntity patient;

    @ManyToOne(targetEntity = DoctorEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private DoctorEntity doctor;

   // @Type(type = "org.jadira.usertype.date.joda.PersistentDate")
    @Column(name = "сreation_date", nullable = false)
    private LocalDate сreationDate;

    //@Type(type = "org.jadira.usertype.date.joda.PersistentDate")
    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private Priority priority;
}

