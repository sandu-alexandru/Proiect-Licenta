package com.training.quizzer.ui.view;

import com.training.quizzer.model.User;
import com.training.quizzer.service.LevelService;
import com.training.quizzer.service.UserService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringView(name = Level6View.VIEW_NAME)
public class Level6View extends VerticalLayout implements View{
    public static final String VIEW_NAME = "level6View";
    public static final String CURRET_LEVEL = "6";

    @Autowired
    private UserService userService;
    private User user;

    @Autowired
    private LevelService levelService;

    private Grid<Level1View.Person> resultsGrid;
    private HorizontalLayout buttonsLayout;
    private Button returnButton;
    private Button testButton;
    private Button trainingButton;
    private Label infoLabel;


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @PostConstruct
    private void init() {
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        setComponents();
    }

    private void setComponents() {
        configureComponents();
    }

    private void configureComponents() {
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        configureResultsGrid();
        configureButtonsLayout();
        infoLabel = new Label("You need to have an average score of 3.0 or above to unlock Test mode");

        addComponent(new Label());
        addComponent(new Label(" Level 6 evaluation "));
        addComponent(new Label());
        addComponent(new Label());
        addComponent(new Label(" Latest results: "));
        addComponent(new Label());
        addComponent(resultsGrid);
        addComponent(new Label());
        if(!user.getCurrentLevel().equals(CURRET_LEVEL)) {
            addComponent(new Label("**These are the statistics for you current level, being " + user.getCurrentLevel()));
            addComponent(new Label("**Any training sessions or tests executed here won't count on the score board"));
        }
        addComponent(new Label());
        addComponent(buttonsLayout);
        addComponent(new Label());
        addComponent(infoLabel);

        checkUserStatus();
    }

    private void checkUserStatus() {
        double firstResult = Double.parseDouble(user.getLast1());
        double secondResult = Double.parseDouble(user.getLast2());
        double thirdResult = Double.parseDouble(user.getLast3());
        double average = (firstResult + secondResult  + thirdResult)/3;
        if (average < 3 && user.getCurrentLevel().equals(CURRET_LEVEL)) {
            testButton.setEnabled(false);
            infoLabel.setVisible(true);
        } else {
            testButton.setEnabled(true);
            infoLabel.setVisible(false);
        }
    }

    private void configureButtonsLayout() {
        buttonsLayout = new HorizontalLayout();
        returnButton = new Button("Return");
        testButton = new Button("Start test");
        trainingButton = new Button("Training");

        buttonsLayout.setWidth("500");

        buttonsLayout.addComponents(returnButton, testButton, trainingButton);
        buttonsLayout.setComponentAlignment(returnButton, Alignment.MIDDLE_LEFT);
        buttonsLayout.setComponentAlignment(testButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setComponentAlignment(trainingButton, Alignment.MIDDLE_RIGHT);

        addButtonListeners();
    }

    private void addButtonListeners() {
        returnButton.addClickListener(event -> getUI().getNavigator().navigateTo(MainQuizzerView.VIEW_NAME));
        testButton.addClickListener(clickEvent -> {
            getUI().getNavigator().navigateTo(Level6TestView.VIEW_NAME);
        });
        trainingButton.addClickListener(clickEvent -> {
            getUI().getNavigator().navigateTo(Level6TrainingView.VIEW_NAME);
        });
    }

    private void configureResultsGrid() {
        resultsGrid = new Grid<>();
        List<Level1View.Person> results = Arrays.asList(
                new Level1View.Person(user.getName(), user.getLast1(), user.getLast2(), user.getLast3()));
        resultsGrid.setItems(results);
        resultsGrid.addColumn(Level1View.Person::getName).setCaption(" Name ");
        resultsGrid.addColumn(Level1View.Person::getLast1).setCaption(" Latest result ");
        resultsGrid.addColumn(Level1View.Person::getLast2).setCaption(" Last result 2 ");
        resultsGrid.addColumn(Level1View.Person::getLast3).setCaption(" Last result 3 ");
        resultsGrid.setHeight("78");
    }

}
