package com.training.quizzer.ui.view;

import com.training.quizzer.model.User;
import com.training.quizzer.service.UserService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = MainQuizzerView.VIEW_NAME)
public class MainQuizzerView extends VerticalLayout implements View{
    public static final String VIEW_NAME = "mainQuizzerView";
    public User user;

    @Autowired
    UserService userService;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        getUI().getSession();
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        if (user.getFirst().equals(User.First.YES)) {
            getUI().getNavigator().navigateTo(AssessmentView.VIEW_NAME);
        }
    }

    @PostConstruct
    private void init() {
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        setComponents();
    }

    private void setComponents() {
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addComponent(new Label("Quizzer 1.0"));
        addComponent(new Label("Knowledge improvement application platform"));
        addComponent(new Label());
        addComponent(new Label());
        addComponent(new Label());
        addComponent(new Label("User:     " + user.getName()));
        addComponent(new Label("Role:     " + user.getRole()));
        addComponent(new Label());
        addComponent(new Label());
        addComponent(new Label("Domain:     " + user.getDomain()));
        addComponent(new Label("Current Level:     " + user.getCurrentLevel()));
        addComponent(new Label());
        addComponent(new Label());
        addComponent(new Label("The purpose of this app is to help the user improve and test his knowledge "));
        addComponent(new Label("with the use of our questions database, as well as through the training program."));
        addComponent(new Label());
        addComponent(new Label("After having a minimum of 60% on the last 3 training sessions for his current level,"));
        addComponent(new Label("The user is allowed to take a test which, if passed, enables access to the next level."));
    }

}
