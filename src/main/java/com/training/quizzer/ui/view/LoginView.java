package com.training.quizzer.ui.view;

import java.util.logging.Logger;

import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.training.quizzer.model.User;
import com.training.quizzer.service.UserAttemptsService;
import com.training.quizzer.service.UserService;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.ValidationResult;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;

@SpringView(name = LoginView.VIEW_NAME)
public class LoginView extends CustomComponent implements View/*, Button.ClickListener*/ {

	private static final long serialVersionUID = 1L;
	public static final String VIEW_NAME = "login";
	private static final Logger logger = Logger.getLogger(LoginView.class.getName());
    private final TextField userTF;
    private final PasswordField passwordF;
    private final Button loginButton;
    private final Button registerButton;

    @Autowired
    private UserService userService;
    @Autowired
    private UserAttemptsService userAttemptsService;
    
    public LoginView() {
        setSizeFull();

        // Create the user input field
//        userTF = new TextField("User:");
        userTF = new TextField();
        userTF.setWidth("300px");
        userTF.setPlaceholder("Input username ...");
        userTF.setMaxLength(60);

        // Create the password input field
//        passwordF = new PasswordField("Password:");
        passwordF = new PasswordField();
        passwordF.setWidth("300px");
        passwordF.setPlaceholder("Input password ...");

        Binder<User> binder = new Binder<>();
        binder.forField(userTF).asRequired("Username cannot be empty!").bind(User::getName, User::setName);
        
        // Password must be at least 8 characters long and contain at least one number
        binder.forField(passwordF).asRequired("Password cannot be empty!").bind(User::getPassword, User::setPassword);
        
        User userBean = new User();
		binder.readBean(userBean);
		
        // Create login button
        loginButton = new Button("Login", event -> {
        	try {
				binder.writeBean(userBean);
				logger.info("user validated" + userBean.toString());
				
				//validate user + password
				User findByNameAndPassword = userService.findByNameAndPassword(userBean.getName(), userBean.getPassword());

				if (findByNameAndPassword == null) {
					User userName = userService.findByName(userBean.getName());
					logger.info("Find user only by name for login attempt = " + userName);
					if(userName!=null) {
						if(User.Status.ACTIVE == userName.getStatus()) {
							userAttemptsService.updateFailAttempts(userName);
						} else {
							// if user has status INACTIVE and one hour has passed (since last attempt), then reset user attempts and put user status ACTIVE
							// if user has status INACTIVE and it has not passed an hour, then do nothing
							User userWithStatusReset = userAttemptsService.resetUserAttemptsAndStatus(userName);
							if(userWithStatusReset != null) {
								userAttemptsService.updateFailAttempts(userWithStatusReset);
							}
						}
					}
					Notification.show("Credentials not valid!");
					userTF.focus();
				} else {
					if(User.Status.INACTIVE == findByNameAndPassword.getStatus()) {
						User userWithStatusReset = userAttemptsService.resetUserAttemptsAndStatus(findByNameAndPassword);
						
						if(userWithStatusReset != null) {
							getSession().setAttribute("user", findByNameAndPassword);
							getUI().getNavigator().navigateTo(MainQuizzerView.VIEW_NAME); // Navigate to main view
						} else {
							Notification.show(
									"Account inactive, please contact the system administrator in order to activate your account",
									Notification.Type.ERROR_MESSAGE);							
						}
						
					} else {
						getSession().setAttribute("user", findByNameAndPassword);

						// Navigate to main view
						getUI().getNavigator().navigateTo(MainQuizzerView.VIEW_NAME);
					}
				}
				
			} catch (ValidationException e) {
				logger.info("LOGG validation exception: " + e.getMessage());
				StringBuilder validationErrorsSb = new StringBuilder();
				for(ValidationResult validationError : e.getValidationErrors()){
					validationErrorsSb.append(validationError.getErrorMessage()).append(" ");
				}
				logger.info("Login failed for user: " + userBean.toString() + ". Errors: "+ validationErrorsSb.toString());
				Notification.show(validationErrorsSb.toString());
				userTF.focus();				
			}
        });
        registerButton = new Button("Register", clickEvent -> {
        	getUI().getNavigator().navigateTo(RegisterView.VIEW_NAME);
        });
        loginButton.setClickShortcut(KeyCode.ENTER);
        
        FormLayout form = new FormLayout();
        form.setCaptionAsHtml(true);
        form.addComponent(userTF);
        form.addComponent(passwordF);

		HorizontalLayout buttonsLayout = new HorizontalLayout();
		buttonsLayout.setWidth("300");
		buttonsLayout.addComponents(loginButton, registerButton);
		buttonsLayout.setComponentAlignment(loginButton, Alignment.MIDDLE_LEFT);
		buttonsLayout.setComponentAlignment(registerButton, Alignment.MIDDLE_RIGHT);
        form.addComponent(buttonsLayout);

        form.setMargin(true);
        form.setSizeUndefined();
      
        Panel panel = new Panel("Login on Quizzer");
        panel.setSizeUndefined();
        panel.setContent(form);
        
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();
        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        verticalLayout.addComponent(panel);
        
        setCompositionRoot(verticalLayout);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // focus the username field when user arrives to the login view
        userTF.focus();
    }
 
}