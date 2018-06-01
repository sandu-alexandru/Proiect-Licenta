package com.training.quizzer.ui.view;

import com.training.quizzer.model.User;
import com.training.quizzer.repository.DomainRepository;
import com.training.quizzer.service.UserService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = MainQuizzerView.VIEW_NAME)
public class MainQuizzerView extends VerticalLayout implements View{
    public static final String VIEW_NAME = "mainQuizzerView";
    public User user;

    @Autowired
    DomainRepository domainRepository;

    @Autowired
    UserService userService;

    VerticalLayout domainChangeLayout;
    ComboBox<String> availableDomainsCombobox;

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

        availableDomainsCombobox = new ComboBox<>();
        availableDomainsCombobox.setItems(domainRepository.getDomains());

        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addComponent(new Label("Quizzer 1.0"));
        addComponent(new Label("Knowledge improvement application platform"));
        addComponent(new Label());
        addComponent(new Label());
        addComponent(new Label("User:     " + user.getName()));
        addComponent(new Label("Role:     " + user.getRole()));
        addComponent(new Label());
//        addComponent(new Label("Domain:     " + user.getDomain()));

        HorizontalLayout domainLayout = new HorizontalLayout();
        availableDomainsCombobox.setSelectedItem(user.getDomain());

        availableDomainsCombobox.addValueChangeListener(event -> activateDomainChangeLayout());

        domainLayout.addComponents(new Label("Domain: "), availableDomainsCombobox);
        addComponent(domainLayout);

        addComponent(new Label("Current Level:     " + user.getCurrentLevel()));
        addComponent(new Label());

        // Code used for the domain change
        domainChangeLayout = new VerticalLayout();
        domainChangeLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        domainChangeLayout.addComponent(new Label("If you change your domain of activity, you will loose your current level and it will be reset to 1."));
        domainChangeLayout.addComponent(new Label("Do you want to continue? "));

        Button confirmDomainChange = new Button("Yes");
        confirmDomainChange.setWidth("80");
        Button cancelDomainChange = new Button("Cancel");
        cancelDomainChange.setWidth("80");

        HorizontalLayout domainChangeButtonsLayout = new HorizontalLayout();
        domainChangeButtonsLayout.addComponents(confirmDomainChange, cancelDomainChange);

        domainChangeLayout.addComponent(domainChangeButtonsLayout);
        addComponent(domainChangeLayout);
        domainChangeLayout.setVisible(false);

        confirmDomainChange.addClickListener(event -> handleDomainChange(availableDomainsCombobox.getSelectedItem().get()));
        cancelDomainChange.addClickListener(event -> {
            revertToOriginalDomain();
        });

        // General app description
        addComponent(new Label());
        addComponent(new Label("The purpose of this app is to help the user improve and test his knowledge "));
        addComponent(new Label("with the use of our questions database, as well as through the training program."));
        addComponent(new Label());
        addComponent(new Label("After having a minimum of 60% on the last 3 training sessions for his current level,"));
        addComponent(new Label("The user is allowed to take a test which, if passed, enables access to the next level."));
    }

    private void revertToOriginalDomain() {
        domainChangeLayout.setVisible(false);
        availableDomainsCombobox.setSelectedItem(user.getDomain());
    }

    private void handleDomainChange(String newDomain) {
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        user.setDomain(newDomain);
        user.setFirst(User.First.YES);
        user.setCurrentLevel("1");
        userService.saveUser(user);
        getUI().getNavigator().navigateTo(MainQuizzerView.VIEW_NAME);
    }

    private void activateDomainChangeLayout() {
        domainChangeLayout.setVisible(true);
    }

}
