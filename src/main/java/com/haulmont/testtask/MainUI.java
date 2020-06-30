package com.haulmont.testtask;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


@Theme(ValoTheme.THEME_NAME)
public class MainUI extends UI {





    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);
//        Session session =  em.unwrap(Session.class);
//        Transaction tx = session.getTransaction();
//        tx.begin();
//        DoctorEntity doctor1 = DoctorEntity.builder().name("Иван").surname("Иванович").patronymic("Иванов").specialization("терапевт").build();
//        PatientEntity patient1 = PatientEntity.builder().name("Сергей").surname("Петрович").patronymic("Петров").phone("88002008001").build();
//        RecipeEntity recipe1 = RecipeEntity.builder().description("Таблетки").patient(patient1).doctor(doctor1).сreationDate(new LocalDate()).expirationDate(new LocalDate().plusWeeks(1)).priority(Priority.Normal).build();
//
//        session.save(doctor1);
//        session.save(patient1);
//        session.save(recipe1);
//
//        session.flush();
//        tx.commit();
//
//        RecipeEntity rec1 =  session.find(RecipeEntity.class,recipe1.getId());

        layout.addComponent(new Label("Hi"));

        setContent(layout);
    }
}