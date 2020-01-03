//package com.example.managermonster.views.masterdetail;
//
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.html.Label;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//
//import com.example.managermonster.MainView;
//@Route(value = "masterdetail", layout = MainView.class)
//@PageTitle("MasterDetail")
//@CssImport("styles/views/masterdetail/master-detail-view.css")
//public class MasterDetailView extends Div {
//
//    public MasterDetailView() {
//        setId("master-detail-view");
//        add(new Label("Content placeholder"));
//    }
//
//}

package com.example.managermonster.views.masterdetail;

import com.example.managermonster.backend.Monster;
import com.example.managermonster.views.dashboard.DashboardView;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.managermonster.backend.BackendService;
import com.example.managermonster.backend.Employee;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.example.managermonster.MainView;
@Route(value = "masterdetail", layout = MainView.class)
@PageTitle("MasterDetail")
@CssImport("styles/views/masterdetail/master-detail-view.css")
public class MasterDetailView extends Div implements AfterNavigationObserver {

    @Autowired
    private BackendService service;

    private Grid<Employee> employees;
    private Grid<Monster> monsters;

    private TextField monsterName = new TextField();
    private TextField monsterNumber = new TextField();
    private TextField lightOlive = new TextField();
    private TextField darkPurple = new TextField();
    private TextField neonGreen =  new TextField();
    private TextField lightRed =  new TextField();
    private TextField chartreuse =  new TextField();
    private TextField red =  new TextField();
    private TextField yellow =  new TextField();
    private TextField thistle =  new TextField();

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    //    private Binder<Employee> binder;
    private Binder<Monster> binder;

    public MasterDetailView() {
        setId("master-detail-view");
        // Configure Grid
        monsters = new Grid<>();
        monsters.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        monsters.setHeightFull();
        monsters.addColumn(Monster::getMonsterNumber).setHeader("Monster Number");
        monsters.addColumn(Monster::getMonsterName).setHeader("Monster Name");
        monsters.addColumn(Monster::getLightOlive).setHeader("LightOlive");
        monsters.addColumn(Monster::getRed).setHeader("Red");
        monsters.addColumn(Monster::getYellow).setHeader("Yellow");
        monsters.addColumn(Monster::getDarkPurple).setHeader("DarkPurple");
        monsters.addColumn(Monster::getNeonGreen).setHeader("NeonGreen");
        monsters.addColumn(Monster::getLightRed).setHeader("LightRed");
        monsters.addColumn(Monster::getChartreuse).setHeader("Chartreuse");
        monsters.addColumn(Monster::getThistle).setHeader("Thistle");

//        employees = new Grid<>();
//        employees.addThemeVariants(GridVariant.LUMO_NO_BORDER);
//        employees.setHeightFull();
//        employees.addColumn(Employee::getFirstname).setHeader("First name");
//        employees.addColumn(Employee::getLastname).setHeader("Last name");
//        employees.addColumn(Employee::getEmail).setHeader("Email");

        //when a row is selected or deselected, populate form
//        employees.asSingleSelect().addValueChangeListener(event -> populateForm(event.getValue()));
        monsters.asSingleSelect().addValueChangeListener(event -> populateForm(event.getValue()));

        // Configure Form
//        binder = new Binder<>(Employee.class);
        binder = new Binder<>(Monster.class);

        // Bind fields. This where you'd define e.g. validation rules
        binder.bindInstanceFields(this);
        // note that password field isn't bound since that property doesn't exist in
        // Employee

        // the grid valueChangeEvent will clear the form too
//        cancel.addClickListener(e -> employees.asSingleSelect().clear());
        cancel.addClickListener(e -> monsters.asSingleSelect().clear());

        save.addClickListener(e -> {
            Notification.show("Beep-boop-beep-beep-boop... updating soon, but not yet.");
        });

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorDiv = new Div();
        editorDiv.setId("editor-layout");
        FormLayout formLayout = new FormLayout();
        addFormItem(editorDiv, formLayout, monsterName, "Monster Name");
        addFormItem(editorDiv, formLayout, monsterNumber, "Monster number");
        addFormItem(editorDiv, formLayout, lightOlive, "LightOlive");
        addFormItem(editorDiv, formLayout, red, "Red");
        addFormItem(editorDiv, formLayout, yellow, "Yellow");
        addFormItem(editorDiv, formLayout, darkPurple, "DarkPurple");
        addFormItem(editorDiv, formLayout, neonGreen, "NeonGreen");
        addFormItem(editorDiv, formLayout, lightRed, "LightRed");
        addFormItem(editorDiv, formLayout, chartreuse, "Chartreuse");
        addFormItem(editorDiv, formLayout, thistle, "Thistle");

        createButtonLayout(editorDiv);
        splitLayout.addToSecondary(editorDiv);
    }

    private void createButtonLayout(Div editorDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setId("button-layout");
        buttonLayout.setWidthFull();
        buttonLayout.setSpacing(true);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(cancel, save);
        editorDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("wrapper");
        wrapper.setWidthFull();
        splitLayout.addToPrimary(wrapper);
//        wrapper.add(employees);
        wrapper.add(monsters);
    }

    private void addFormItem(Div wrapper, FormLayout formLayout,
                             AbstractField field, String fieldName) {
        formLayout.addFormItem(field, fieldName);
        wrapper.add(formLayout);
        field.getElement().getClassList().add("full-width");
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {

        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user
//        employees.setItems(service.getEmployees());
        monsters.setItems(service.getMonsters());
    }

    private void populateForm(Monster value) {
        // Value can be null as well, that clears the form
        binder.readBean(value);

        // The password field isn't bound through the binder, so handle that
//        password.setValue("");
    }
}
