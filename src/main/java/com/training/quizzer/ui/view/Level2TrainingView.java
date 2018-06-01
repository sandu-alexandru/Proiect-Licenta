package com.training.quizzer.ui.view;

import com.training.quizzer.model.Question;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringView(name = Level2TrainingView.VIEW_NAME)
public class Level2TrainingView extends VerticalLayout implements View{
    public static final String VIEW_NAME = "level2TrainingView";
    public static final String CURRET_LEVEL = "2";

    @Autowired
    private UserService userService;
    private User user;

    @Autowired
    private LevelService levelService;

    private Map<Question, String> answersMap;
    private VerticalLayout questionLayout;
    private VerticalLayout mainLayout;
    private Button submitButton;
    private VerticalLayout resultLayout;
    private Button returnButton;
    private double userScore;


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @PostConstruct
    private void init() {
        answersMap = new HashMap<>();
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        setComponents();
    }

    private void setComponents() {
        configureComponents();
        addLevel1Questions();
    }

    private void configureComponents() {
        mainLayout = new VerticalLayout();
        questionLayout  = new VerticalLayout();
        submitButton = new Button("Submit Answers");

        resultLayout = new VerticalLayout();
        returnButton = new Button("Return");
        resultLayout.setVisible(false);

        mainLayout.addComponents(questionLayout, submitButton);
        addComponents(mainLayout, resultLayout);
        addSubmitButtonListener();
    }

    private void addSubmitButtonListener() {
        submitButton.addClickListener(clickEvent -> {
            userScore = 0;
            double desiredScore = getDesiredScore();
            answersMap.keySet().forEach(key -> {
                if(answersMap.get(key).equals(key.getCorrect())) userScore++;
            });

            if (userScore >= desiredScore)
                showResult("success");
            else
                showResult("fail");
        });
        returnButton.addClickListener(clickEvent -> getUI().getNavigator().navigateTo(Level2View.VIEW_NAME));
    }

    private void showResult(String result) {
        resultLayout.addComponent(new Label());
        resultLayout.addComponent(new Label());
        if (result.equals("success")){
            resultLayout.addComponent(new Label(" Awesome, you managed to pass this training session !"));
        } else {
            resultLayout.addComponent(new Label(" Bad luck, you didn't managed to pass !"));
        }
        resultLayout.addComponent(new Label());
        resultLayout.addComponent(new Label("Your score is " + userScore + " points"));
        resultLayout.addComponent(new Label());
        resultLayout.addComponent(returnButton);
        mainLayout.setVisible(false);
        resultLayout.setVisible(true);

        if(user.getCurrentLevel().equals(CURRET_LEVEL)) {
            user.setLast3(user.getLast2());
            user.setLast2(user.getLast1());
            user.setLast1("" + userScore);
            userService.saveUser(user);
        }
    }

    private double getDesiredScore() {
        return answersMap.keySet().size() * 0.6;
    }

    private void addLevel1Questions() {
        levelService.getLevel1Questions(5, user.getDomain()).forEach(
                level1Question -> {
                    Question question = new Question(
                            level1Question.getDomain(), level1Question.getQuestion(),
                            level1Question.getAnswer1(), level1Question.getAnswer2(), level1Question.getAnswer3(),
                            level1Question.getCorrect());
                    String answer = "";
                    prepareQuestion(question, answer);
                }
        );
    }

    private void prepareQuestion(Question question, String answer) {
        RadioButtonGroup<String> options = new RadioButtonGroup<>();
        List<String> answers = new ArrayList<>();

        answers.add(question.getAnswer1());
        answers.add(question.getAnswer2());
        answers.add(question.getAnswer3());

        options.setCaption(question.getQuestion());
        options.setItems(answers);

        answersMap.put(question, answer);
        options.addValueChangeListener(valueChangeEvent -> {
            String newAnswer = options.getSelectedItem().get();
            String questionCaption = options.getCaption();
            answersMap.keySet().forEach(key->{
                if(key.getQuestion().equals(questionCaption)) {
                    answersMap.put(key, newAnswer);
                }
            });
        });

        questionLayout.addComponent(options);
        questionLayout.addComponent(new Label());

    }


}
