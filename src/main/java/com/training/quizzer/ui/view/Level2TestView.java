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

@SpringView(name = Level2TestView.VIEW_NAME)
public class Level2TestView extends VerticalLayout implements View{
    public static final String VIEW_NAME = "level2TestView";
    public static final String CURRENT_LEVEL = "2";
    public static final String NEXT_LEVEL= "3";

    @Autowired
    private UserService userService;
    private User user;

    @Autowired
    private LevelService levelService;

    private Map<Question, String> answersMap1;
    private Map<Question, String> answersMap2;
    private VerticalLayout questionLayout;
    private Button submitButton;
    private double userScore;
    private VerticalLayout resultLayout;
    private Button returnButton;
    private VerticalLayout mainLayout;


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @PostConstruct
    private void init() {
        answersMap1 = new HashMap<>();
        answersMap2 = new HashMap<>();
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        setComponents();
    }

    private void setComponents() {
        configureComponents();
        addLevel1Questions();
        addLevel2Questions();
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
            answersMap1.keySet().forEach(key -> {
                if(answersMap1.get(key).equals(key.getCorrect())) userScore++;
            });
            answersMap2.keySet().forEach(key -> {
                if(answersMap2.get(key).equals(key.getCorrect())) userScore++;
            });

            if (userScore >= desiredScore){
                showResult("success");
                returnButton.addClickListener(event -> getUI().getNavigator().navigateTo(Level3View.VIEW_NAME));
            } else {
                showResult("fail");
                returnButton.addClickListener(event -> getUI().getNavigator().navigateTo(Level2View.VIEW_NAME));
            }
        });
    }

    private void showResult(String result) {
        resultLayout.addComponent(new Label());
        resultLayout.addComponent(new Label());
        if (result.equals("success")){
            resultLayout.addComponent(new Label(" Felicitari, ai trecut la nivelul urmator !!!"));
        } else {
            resultLayout.addComponent(new Label(" Ghinion, nu ai reusit sa treci! Mai invata!"));
        }
        resultLayout.addComponent(new Label());
        resultLayout.addComponent(new Label("Scorul tau este de " + userScore + " puncte"));
        resultLayout.addComponent(new Label());
        resultLayout.addComponent(returnButton);
        mainLayout.setVisible(false);
        resultLayout.setVisible(true);

        if(Integer.parseInt(user.getCurrentLevel()) < Integer.parseInt(NEXT_LEVEL) ) {
            user.setCurrentLevel(NEXT_LEVEL);
            user.setLast3("0");
            user.setLast2("0");
            user.setLast1("0");
            userService.saveUser(user);
        }
    }


    private double getDesiredScore() {
        return (answersMap1.keySet().size() + answersMap2.keySet().size()) * 0.6;
    }

    private void addLevel1Questions() {
        levelService.getLevel1Questions(5, user.getDomain()).forEach(
                level1Question -> {
                    Question question = new Question(
                            level1Question.getDomain(), level1Question.getQuestion(),
                            level1Question.getAnswer1(), level1Question.getAnswer2(), level1Question.getAnswer3(),
                            level1Question.getCorrect());
                    String answer = "";
                    prepareQuestion(question, answer, 1);
                }
        );
    }

    private void addLevel2Questions() {
        levelService.getLevel2Questions(5, user.getDomain()).forEach(
                level2Question -> {
                    Question question = new Question(
                            level2Question.getDomain(), level2Question.getQuestion(),
                            level2Question.getAnswer1(), level2Question.getAnswer2(), level2Question.getAnswer3(),
                            level2Question.getCorrect());
                    String answer = "";
                    prepareQuestion(question, answer, 2);
                }
        );
    }

    private void prepareQuestion(Question question, String answer, int level) {
        RadioButtonGroup<String> options = new RadioButtonGroup<>();
        List<String> answers = new ArrayList<>();

        answers.add(question.getAnswer1());
        answers.add(question.getAnswer2());
        answers.add(question.getAnswer3());

        options.setCaption(question.getQuestion());
        options.setItems(answers);

        if(level == 1) {
            answersMap1.put(question, answer);
            options.addValueChangeListener(valueChangeEvent -> {
                String newAnswer = options.getSelectedItem().get();
                String questionCaption = options.getCaption();
                answersMap1.keySet().forEach(key->{
                    if(key.getQuestion().equals(questionCaption)) {
                        answersMap1.put(key, newAnswer);
                    }
                });
            });
        } else if (level == 2){
            answersMap2.put(question, answer);
            options.addValueChangeListener(valueChangeEvent -> {
                String newAnswer = options.getSelectedItem().get();
                String questionCaption = options.getCaption();
                answersMap2.keySet().forEach(key->{
                    if(key.getQuestion().equals(questionCaption)) {
                        answersMap2.put(key, newAnswer);
                    }
                });
            });
        }



        questionLayout.addComponent(options);
        questionLayout.addComponent(new Label());

    }


}
