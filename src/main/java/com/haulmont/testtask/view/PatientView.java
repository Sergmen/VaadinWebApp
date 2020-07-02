package com.haulmont.testtask.view;

import com.haulmont.testtask.entities.PatientEntity;
import com.haulmont.testtask.service.PatientService;
//import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.annotations.VaadinServletConfiguration;
//import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.servlet.annotation.WebServlet;
import java.util.Spliterator;
import java.util.function.Consumer;

public class PatientView  extends UI
{

    private final PatientService patientService = PatientService.getInstance();
    private Grid<PatientEntity> patientGrid= new Grid<>(PatientEntity.class);
    private final TextField filterText = new TextField();
  //  private final Button addNewButton = new Button("New patient", VaadinIcon.PLUS.create());
 //   private final HorizontalLayout toolbar = new HorizontalLayout(filter, addNewButton);


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        filterText.setPlaceholder("filter by name...");
        filterText.addValueChangeListener(e -> fillList(""));
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button clearFilterTextBtn = new Button();
        clearFilterTextBtn.setDescription("Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> filterText.clear());

        CssLayout filtering = new CssLayout();
        filtering.addComponents(filterText, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        Button addCustomerBtn = new Button("Add new customer");
        addCustomerBtn.addClickListener(e -> {
            patientGrid.asSingleSelect().clear();
            //   form.setCustomer(new Customer());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filtering, addCustomerBtn);

        patientGrid.setColumns("id","name", "surname", "patronymic","phone");

        HorizontalLayout main = new HorizontalLayout(patientGrid);
        main.setSizeFull();
        patientGrid.setSizeFull();
        main.setExpandRatio(patientGrid, 1);

        layout.addComponents(toolbar, main);

        fillList("");

        setContent(layout);



    }


    private void fillList(String name) {
        if (name.isEmpty()) {
            patientGrid.setItems(patientService.findAll());
        } else {
            patientGrid.setItems(patientService.findByName(name));
        }
    }




    @WebServlet(urlPatterns = "/patient", name = "Patient", asyncSupported = true)
    @VaadinServletConfiguration(ui = PatientView.class, productionMode = false)
    public static class PatientServlet extends VaadinServlet {
    }

}
