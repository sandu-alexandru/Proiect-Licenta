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

@SpringView(name = Level6TestView.VIEW_NAME)
public class Level6TestView extends VerticalLayout implements View{
    public static final String VIEW_NAME = "level6TestView";
    public static final String CURRENT_LEVEL = "6";
    public static final String NEXT_LEVEL= "7";

    @Autowired
    private UserService userService;
    private User user;

    @Autowired
    private LevelService levelService;

    private Map<Question, String> answersMap1;
    private Map<Question, String> answersMap2;
    private Map<Question, String> answersMap3;
    private Map<Question, String> answersMap4;
    private Map<Question, String> answersMap5;
    private Map<Question, String> answersMap6;
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
        answersMap3 = new HashMap<>();
        answersMap4 = new HashMap<>();
        answersMap5 = new HashMap<>();
        answersMap6 = new HashMap<>();
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        setComponents();
    }

    private void setComponents() {
        configureComponents();
        addLevel1Questions();
        addLevel2Questions();
        addLevel3Questions();
        addLevel4Questions();
        addLevel5Questions();
        addLevel6Questions();
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
            answersMap3.keySet().forEach(key -> {
                if(answersMap3.get(key).equals(key.getCorrect())) userScore++;
            });
            answersMap4.keySet().forEach(key -> {
                if(answersMap4.get(key).equals(key.getCorrect())) userScore++;
            });
            answersMap5.keySet().forEach(key -> {
                if(answersMap5.get(key).equals(key.getCorrect())) userScore++;
            });
            answersMap6.keySet().forEach(key -> {
                if(answersMap6.get(key).equals(key.getCorrect())) userScore++;
            });

            if (userScore >= desiredScore){
                showResult("success");
                returnButton.addClickListener(event -> getUI().getNavigator().navigateTo(Level7View.VIEW_NAME));
            } else{
                showResult("fail");
                returnButton.addClickListener(event -> getUI().getNavigator().navigateTo(Level6View.VIEW_NAME));
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
        return (answersMap1.keySet().size() + answersMap2.keySet().size() + answersMap3.keySet().size()
                + answersMap4.keySet().size() + answersMap5.keySet().size() + answersMap6.keySet().size()) * 0.6;
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

    private void addLevel3Questions() {
        levelService.getLevel3Questions(5, user.getDomain()).forEach(
                level2Question -> {
                    Question question = new Question(
                            level2Question.getDomain(), level2Question.getQuestion(),
                            level2Question.getAnswer1(), level2Question.getAnswer2(), level2Question.getAnswer3(),
                            level2Question.getCorrect());
                    String answer = "";
                    prepareQuestion(question, answer, 3);
                }
        );
    }

    private void addLevel4Questions() {
        levelService.getLevel4Questions(5, user.getDomain()).forEach(
                level4Question -> {
                    Question question = new Question(
                            level4Question.getDomain(), level4Question.getQuestion(),
                            level4Question.getAnswer1(), level4Question.getAnswer2(), level4Question.getAnswer3(),
                            level4Question.getCorrect());
                    String answer = "";
                    prepareQuestion(question, answer, 4);
                }
        );
    }

    private void addLevel5Questions() {
        levelService.getLevel5Questions(5, user.getDomain()).forEach(
                level5Question -> {
                    Question question = new Question(
                            level5Question.getDomain(), level5Question.getQuestion(),
                            level5Question.getAnswer1(), level5Question.getAnswer2(), level5Question.getAnswer3(),
                            level5Question.getCorrect());
                    String answer = "";
                    prepareQuestion(question, answer, 5);
                }
        );
    }

    private void addLevel6Questions() {
        levelService.getLevel6Questions(5, user.getDomain()).forEach(
                level6Question -> {
                    Question question = new Question(
                            level6Question.getDomain(), level6Question.getQuestion(),
                            level6Question.getAnswer1(), level6Question.getAnswer2(), level6Question.getAnswer3(),
                            level6Question.getCorrect());
                    String answer = "";
                    prepareQuestion(question, answer, 6);
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
        } else if (level == 3){
            answersMap3.put(question, answer);
            options.addValueChangeListener(valueChangeEvent -> {
                String newAnswer = options.getSelectedItem().get();
                String questionCaption = options.getCaption();
                answersMap3.keySet().forEach(key->{
                    if(key.getQuestion().equals(questionCaption)) {
                        answersMap3.put(key, newAnswer);
                    }
                });
            });
        } else if (level == 4){
            answersMap4.put(question, answer);
            options.addValueChangeListener(valueChangeEvent -> {
                String newAnswer = options.getSelectedItem().get();
                String questionCaption = options.getCaption();
                answersMap4.keySet().forEach(key->{
                    if(key.getQuestion().equals(questionCaption)) {
                        answersMap4.put(key, newAnswer);
                    }
                });
            });
        } else if (level == 5){
            answersMap5.put(question, answer);
            options.addValueChangeListener(valueChangeEvent -> {
                String newAnswer = options.getSelectedItem().get();
                String questionCaption = options.getCaption();
                answersMap5.keySet().forEach(key->{
                    if(key.getQuestion().equals(questionCaption)) {
                        answersMap5.put(key, newAnswer);
                    }
                });
            });
        } else if (level == 6){
            answersMap6.put(question, answer);
            options.addValueChangeListener(valueChangeEvent -> {
                String newAnswer = options.getSelectedItem().get();
                String questionCaption = options.getCaption();
                answersMap6.keySet().forEach(key->{
                    if(key.getQuestion().equals(questionCaption)) {
                        answersMap6.put(key, newAnswer);
                    }
                });
            });
        }

        questionLayout.addComponent(options);
        questionLayout.addComponent(new Label());

    }


}
