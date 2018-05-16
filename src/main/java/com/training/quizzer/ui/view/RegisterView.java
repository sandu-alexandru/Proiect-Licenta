package com.training.quizzer.ui.view;

import com.sun.org.apache.regexp.internal.RE;
import com.training.quizzer.model.User;
import com.training.quizzer.repository.DomainRepository;
import com.training.quizzer.service.UserService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Stream;

@SpringView(name = RegisterView.VIEW_NAME)
public class RegisterView extends CustomComponent implements View {
    public static final String VIEW_NAME = "registerView";
    public User user;

    @Autowired
    UserService userService;

    @Autowired
    DomainRepository domainRepository;

    private Button confirmRegistrationButton;
    private Button cancelButton;
    private TextField usernameTextField;
    private PasswordField passwordField;
    private PasswordField confirmPasswordField;
//    private ComboBox<User.Domain> domainComboBox;
    private ComboBox<String> domainComboBox;
    private Stream domains;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @PostConstruct
    private void init() {
        setComponents();
    }

    private void setComponents() {
        buildMainLayout();
        addListeners();
    }

    private void buildMainLayout() {
        setSizeFull();

        configureComponents();

        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.setWidth("300");
        buttonsLayout.addComponents(confirmRegistrationButton, cancelButton);
        buttonsLayout.setComponentAlignment(confirmRegistrationButton, Alignment.MIDDLE_LEFT);
        buttonsLayout.setComponentAlignment(cancelButton, Alignment.MIDDLE_RIGHT);

        FormLayout form = new FormLayout();
        form.setCaptionAsHtml(true);
        form.addComponents(usernameTextField, passwordField, confirmPasswordField);
        form.addComponent(domainComboBox);
        form.addComponent(buttonsLayout);
        form.setMargin(true);
        form.setSizeUndefined();

        Panel panel = new Panel("Register on Quizzer");
        panel.setSizeUndefined();
        panel.setContent(form);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        verticalLayout.addComponent(panel);

        setCompositionRoot(verticalLayout);
    }

    private void configureComponents() {
        confirmRegistrationButton = new Button("Register");
        cancelButton = new Button("Cancel");

        usernameTextField = new TextField();
        usernameTextField.setWidth("300px");
        usernameTextField.setPlaceholder("Input username ...");

        passwordField = new PasswordField();
        passwordField.setWidth("300");
        passwordField.setPlaceholder("Input password ...");

        confirmPasswordField = new PasswordField();
        confirmPasswordField.setWidth("300");
        confirmPasswordField.setPlaceholder("Confirm password ...");

        domainComboBox  = new ComboBox<>();
        domainComboBox.setTextInputAllowed(false);
//        domains = Stream.of(User.Domain.values());
        List<String> domains = domainRepository.getDomains();
        domainComboBox.setItems(domains);
    }

    private void addListeners() {
        confirmRegistrationButton.addClickListener(clickEvent ->{
            if(validData()) {
                if(userNotTaken()){
                    if (passwordField.getValue().equals(confirmPasswordField.getValue())){
                        if (validDomainSelection()) {
                            if (registrationSuccessful()) {
                                Notification.show("User " + usernameTextField.getValue()
                                                + "successfully registered",
                                        Notification.Type.WARNING_MESSAGE);
                                getUI().getNavigator().navigateTo(LoginView.VIEW_NAME);
                            } else {
                                Notification.show("There were errors in the registration process",
                                        Notification.Type.WARNING_MESSAGE);
                            }
                        } else {
                            Notification.show("The Domain for the quizzes is not properly selected",
                                    Notification.Type.WARNING_MESSAGE);
                        }
                    } else {
                        Notification.show("Password field does not match with the confirmation field",
                                Notification.Type.WARNING_MESSAGE);
                    }
                } else {
                    Notification.show("Username already taken ", Notification.Type.WARNING_MESSAGE);
                }
            } else {
                Notification.show("Please input valid data !!! ", Notification.Type.WARNING_MESSAGE);
            }
        });
        cancelButton.addClickListener(clickEvent -> {
            getUI().getNavigator().navigateTo(LoginView.VIEW_NAME);
        });
    }

    private boolean validData() {
        if(usernameTextField.isEmpty() || passwordField.isEmpty()
                || confirmPasswordField.isEmpty() || !validDomainSelection()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validDomainSelection() {
        try {
            System.out.println(domainComboBox.getSelectedItem().get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean userNotTaken() {
        User dbCompare = userService.findByName(usernameTextField.getValue());
        if (dbCompare == null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean registrationSuccessful() {
        try {
            User registrationUser = new User();

            registrationUser.setName(usernameTextField.getValue());
            registrationUser.setPassword(passwordField.getValue());
            registrationUser.setDomain(domainComboBox.getSelectedItem().get());
            registrationUser.setStatus(User.Status.ACTIVE);
            registrationUser.setFirst(User.First.YES);
            registrationUser.setRole(User.Role.USER);
            registrationUser.setCurrentLevel("1");
            registrationUser.setLast1("0");
            registrationUser.setLast2("0");
            registrationUser.setLast3("0");

            userService.saveUser(registrationUser);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
