package com.haulmont.testtask.view;

import com.haulmont.testtask.entities.PatientEntity;
import com.haulmont.testtask.service.PatientService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Grid;
//import com.vaadin.ui.components.*;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.data.value.ValueChangeMode;
//import com.vaadin.flow.router.Route;
//import com.haulmont.testtask.service.PatientService;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;



//@Route("")
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

        patientGrid.setColumns("name", "surname", "phone");

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
