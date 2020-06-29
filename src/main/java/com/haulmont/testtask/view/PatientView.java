package com.haulmont.testtask.view;

import com.haulmont.testtask.entities.PatientEntity;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.haulmont.testtask.service.PatientService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;



//@Route("")
public class PatientView extends VerticalLayout {

    private final PatientService patientService;

    //private final EmployeeEditor employeeEditor;

    private Grid<PatientEntity> patientGrid= new Grid<>(PatientEntity.class);
    private final TextField filter = new TextField();
    private final Button addNewButton = new Button("New patient", VaadinIcon.PLUS.create());
    private final HorizontalLayout toolbar = new HorizontalLayout(filter, addNewButton);

    public PatientView(PatientService patientService) {
        this.patientService = patientService;

        filter.setPlaceholder("Type to filter");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(field -> fillList(field.getValue()));

        add(toolbar, patientGrid);

//        patientGrid
//                .asSingleSelect()
//                .addValueChangeListener(e -> employeeEditor.editEmployee(e.getValue()));

//        addNewButton.addClickListener(e -> employeeEditor.editEmployee(new Employee()));

//        employeeEditor.setChangeHandler(() -> {
//            employeeEditor.setVisible(false);
//            fillList(filter.getValue());
//        });

        fillList("");



    }

    private void fillList(String name) {
        if (name.isEmpty()) {
            patientGrid.setItems(this.patientService.findAll());
        } else {
            patientGrid.setItems(this.patientService.findByName(name));
        }
    }

}
