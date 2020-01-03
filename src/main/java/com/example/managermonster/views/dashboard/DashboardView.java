package com.example.managermonster.views.dashboard;

import com.example.managermonster.backend.Monster;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.dnd.EffectAllowed;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.data.renderer.ComponentRenderer;
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
import com.vaadin.flow.router.RouteAlias;

import com.example.managermonster.MainView;
@Route(value = "dashboard", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Dashboard")
@CssImport("styles/views/dashboard/dashboard-view.css")
public class DashboardView extends Div implements AfterNavigationObserver {

    @Autowired
    private BackendService service;
//    private final Grid<Employee> grid;
    private final Grid<Monster> grid;

    public DashboardView() {
        setId("dashboard-view");
        grid = new Grid<>();
        grid.setId("list");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
                GridVariant.LUMO_NO_ROW_BORDERS);
        grid.setHeightFull();
        grid.addColumn(new ComponentRenderer<>(monster -> {
            H3 h3 = new H3(
                    monster.getMonsterNumber() + ". " + monster.getMonsterName());
            Anchor anchor = new Anchor("picture:" + monster.getMonsterName(),
                    monster.getMonsterName());
            HtmlComponent br = new HtmlComponent("br");
            Image image = new Image(monster.getImage(), "image");
            anchor.getElement().getThemeList().add("font-size-xs");
            Div div = new Div(h3, anchor, br, image);
            div.addClassName("employee-column");
            return div;
        }));
//        grid.addColumn(new ComponentRenderer<>(employee -> {
//            H3 h3 = new H3(
//                    employee.getLastname() + ", " + employee.getFirstname());
//            Anchor anchor = new Anchor("mailto:" + employee.getEmail(),
//                    employee.getEmail());
//            anchor.getElement().getThemeList().add("font-size-xs");
//            Div div = new Div(h3, anchor);
//            div.addClassName("employee-column");
//            return div;
//        }));

        add(grid);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user
        grid.setItems(service.getMonsters());
    }
}
