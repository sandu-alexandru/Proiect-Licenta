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
import java.util.List;

@SpringView(name = AssessmentView.VIEW_NAME)
public class AssessmentView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "assessmentView";

    private static final int TOTAL_QUESTIONS_NUMBER = 10;
    private int currentQuestionsAnswered = 0;
    private int currentLevel = 1;
    private String currentAnswer;
    private Question currentQuestion;

    @Autowired
    private LevelService levelService;

    @Autowired
    UserService userService;
    public User user;

    private VerticalLayout confirmLayout;
    private VerticalLayout assessmentLayout;

    private VerticalLayout informationalLayout;
    private HorizontalLayout confirmButtonsLayout;
    private HorizontalLayout assessmentButtonsLayout;
    private HorizontalLayout assessmentInfoLayout;
    private VerticalLayout resultLayout;
    private VerticalLayout assessmentQuestionLayout;
    private Button confirmationButton;
    private Button skipButton;
    private Button submitButton;
    private Button cancelButton;
    private Label currentLevelLabel;
    private Label remainingQuestionsLabel;
    private Button finishButton;


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @PostConstruct
    private void init() {
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        setComponents();
    }

    private void setComponents() {
        setSizeFull();
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setConfirmationLayout();
        setAssessmentLayout();
        addComponents(confirmLayout, assessmentLayout);
        assessmentLayout.setVisible(false);
    }

    private void setConfirmationLayout() {
        confirmLayout = new VerticalLayout();
        setInformationalLayout();
        setConfirmationButtonsLayout();
        configureButtonListeners();
    }

    private void setInformationalLayout() {
        informationalLayout = new VerticalLayout();
        informationalLayout.addComponent(new Label(""));
        informationalLayout.addComponent(new Label(""));
        informationalLayout.addComponent(new Label("Since this is the first time you log in on this platform,"));
        informationalLayout.addComponent(new Label("you have the chance of taking an assessment test,"));
        informationalLayout.addComponent(new Label("so we can properly assess your knowledge level"));
        informationalLayout.addComponent(new Label(""));
        informationalLayout.addComponent(new Label(""));

        confirmLayout.addComponent(informationalLayout);
    }

    private void setConfirmationButtonsLayout() {
        confirmButtonsLayout = new HorizontalLayout();
        confirmButtonsLayout.setWidth("400");
        confirmationButton = new Button("Take the test");
        confirmationButton.setWidth("140");
        skipButton = new Button("Skip");
        skipButton.setWidth("140");

        confirmButtonsLayout.addComponents(confirmationButton, skipButton);
        confirmButtonsLayout.setComponentAlignment(confirmationButton, Alignment.MIDDLE_LEFT);
        confirmButtonsLayout.setComponentAlignment(skipButton, Alignment.MIDDLE_RIGHT);

        confirmLayout.addComponent(confirmButtonsLayout);
    }

    private void configureButtonListeners() {
        confirmationButton.addClickListener(clickEvent -> {
            confirmLayout.setVisible(false);
            assessmentLayout.setVisible(true);
        });
        skipButton.addClickListener(clickEvent ->
            getUI().getNavigator().navigateTo(MainQuizzerView.VIEW_NAME)
        );
    }

    private void setAssessmentLayout() {
        assessmentLayout = new VerticalLayout();
        setAssessmentInformationalLayout();
        setAssessmentQuestionLayout();
        setAssessmentButtonsLayout();
        addAssessmentButtonListeners();
    }

    private void setAssessmentInformationalLayout() {
        assessmentInfoLayout = new HorizontalLayout();
        assessmentInfoLayout.setWidth("400");
        currentLevelLabel = new Label();
        remainingQuestionsLabel = new Label();
        setInformationalLabels();

        assessmentInfoLayout.addComponents(currentLevelLabel, remainingQuestionsLabel);

    }

    private void setInformationalLabels() {
        currentLevelLabel.setValue("Current level: " + currentLevel);
        remainingQuestionsLabel.setValue("Remaining questions: " + (TOTAL_QUESTIONS_NUMBER - currentQuestionsAnswered));
    }

    private void setAssessmentQuestionLayout() {
        assessmentQuestionLayout = new VerticalLayout();
        assessmentQuestionLayout.setWidth("400");
        assessmentQuestionLayout.setHeight("350");
        prepareQuestion();
        assessmentLayout.addComponent(assessmentQuestionLayout);
    }

    private void prepareQuestion() {
        if (currentLevel == 1) {
            levelService.getLevel1Questions(1, user.getDomain()).forEach(
                    level1Question -> {
                        Question question = new Question(
                                level1Question.getDomain(), level1Question.getQuestion(),
                                level1Question.getAnswer1(), level1Question.getAnswer2(), level1Question.getAnswer3(),
                                level1Question.getCorrect());
                        currentQuestion = question;
                        currentAnswer = "";
                        addQuestionToLayout(currentQuestion);
                    }
            );
        } else if (currentLevel == 2) {
            levelService.getLevel2Questions(1, user.getDomain()).forEach(
                    level2Question -> {
                        Question question = new Question(
                                level2Question.getDomain(), level2Question.getQuestion(),
                                level2Question.getAnswer1(), level2Question.getAnswer2(), level2Question.getAnswer3(),
                                level2Question.getCorrect());
                        currentQuestion = question;
                        currentAnswer = "";
                        addQuestionToLayout(currentQuestion);
                    }
            );
        } else if (currentLevel == 3) {
            levelService.getLevel3Questions(1, user.getDomain()).forEach(
                    level3Question -> {
                        Question question = new Question(
                                level3Question.getDomain(), level3Question.getQuestion(),
                                level3Question.getAnswer1(), level3Question.getAnswer2(), level3Question.getAnswer3(),
                                level3Question.getCorrect());
                        currentQuestion = question;
                        currentAnswer = "";
                        addQuestionToLayout(currentQuestion);
                    }
            );
        } else if (currentLevel == 4) {
            levelService.getLevel4Questions(1, user.getDomain()).forEach(
                    level4Question -> {
                        Question question = new Question(
                                level4Question.getDomain(), level4Question.getQuestion(),
                                level4Question.getAnswer1(), level4Question.getAnswer2(), level4Question.getAnswer3(),
                                level4Question.getCorrect());
                        currentQuestion = question;
                        currentAnswer = "";
                        addQuestionToLayout(currentQuestion);
                    }
            );
        } else if (currentLevel == 5) {
            levelService.getLevel5Questions(1, user.getDomain()).forEach(
                    level5Question -> {
                        Question question = new Question(
                                level5Question.getDomain(), level5Question.getQuestion(),
                                level5Question.getAnswer1(), level5Question.getAnswer2(), level5Question.getAnswer3(),
                                level5Question.getCorrect());
                        currentQuestion = question;
                        currentAnswer = "";
                        addQuestionToLayout(currentQuestion);
                    }
            );
        } else if (currentLevel == 6) {
            levelService.getLevel6Questions(1, user.getDomain()).forEach(
                    level6Question -> {
                        Question question = new Question(
                                level6Question.getDomain(), level6Question.getQuestion(),
                                level6Question.getAnswer1(), level6Question.getAnswer2(), level6Question.getAnswer3(),
                                level6Question.getCorrect());
                        currentQuestion = question;
                        currentAnswer = "";
                        addQuestionToLayout(currentQuestion);
                    }
            );
        } else if (currentLevel == 7) {
            levelService.getLevel7Questions(1, user.getDomain()).forEach(
                    level7Question -> {
                        Question question = new Question(
                                level7Question.getDomain(), level7Question.getQuestion(),
                                level7Question.getAnswer1(), level7Question.getAnswer2(), level7Question.getAnswer3(),
                                level7Question.getCorrect());
                        currentQuestion = question;
                        currentAnswer = "";
                        addQuestionToLayout(currentQuestion);
                    }
            );
        }
    }

    private void addQuestionToLayout(Question question) {
        RadioButtonGroup<String> options = new RadioButtonGroup<>();
        List<String> answers = new ArrayList<>();

        answers.add(question.getAnswer1());
        answers.add(question.getAnswer2());
        answers.add(question.getAnswer3());

        options.setCaption(question.getQuestion());
        options.setItems(answers);

        options.addValueChangeListener(valueChangeEvent -> {
            currentAnswer = options.getSelectedItem().get();
        });

        assessmentQuestionLayout.removeAllComponents();
        assessmentQuestionLayout.addComponent(options);
    }

    private void setAssessmentButtonsLayout() {
        assessmentButtonsLayout = new HorizontalLayout();
        assessmentButtonsLayout.setWidth("400");
        submitButton = new Button("Submit");
        submitButton.setWidth("140");
        cancelButton = new Button("Cancel");
        cancelButton.setWidth("140");

        assessmentButtonsLayout.addComponents(submitButton, cancelButton);
        assessmentButtonsLayout.setComponentAlignment(submitButton, Alignment.MIDDLE_LEFT);
        assessmentButtonsLayout.setComponentAlignment(cancelButton,Alignment.MIDDLE_RIGHT);
        assessmentLayout.addComponent(assessmentButtonsLayout);
    }

    private void addAssessmentButtonListeners() {
        submitButton.addClickListener(clickEvent -> {
            currentQuestionsAnswered++;
            if(currentAnswer.equals(currentQuestion.getCorrect())) {
                if (currentLevel < 7) currentLevel++;
            } else {
                if (currentLevel > 1) currentLevel--; 
            }
            if (currentQuestionsAnswered == TOTAL_QUESTIONS_NUMBER) {
                showResult();
            } else {
                setInformationalLabels();
                prepareQuestion();
            }
        });
        cancelButton.addClickListener(clickEvent -> {
            user.setFirst(User.First.NO);
            userService.saveUser(user);
            getUI().getNavigator().navigateTo(MainQuizzerView.VIEW_NAME);
        });
    }

    private void showResult() {
        resultLayout = new VerticalLayout();
        setResultLayout();
        saveResults();
        addFinishButton();
        removeAllComponents();
        addComponent(resultLayout);
    }

    private void setResultLayout() {
        resultLayout.addComponent(new Label(""));
        resultLayout.addComponent(new Label(""));
        resultLayout.addComponent(new Label("Congratulations, you completed the initial assessment !"));
        resultLayout.addComponent(new Label(""));
        resultLayout.addComponent(new Label("Your current level is evaluated as " + currentLevel));
        resultLayout.addComponent(new Label("After answering questions from all levels, prepared based on your answers"));
        resultLayout.addComponent(new Label(""));
        resultLayout.addComponent(new Label(""));
    }

    private void saveResults() {
        user.setCurrentLevel("" + currentLevel);
        user.setFirst(User.First.NO);
        userService.saveUser(user);
    }

    private void addFinishButton() {
        finishButton = new Button("Finish");
        finishButton.setWidth("85");

        finishButton.addClickListener(clickEvent -> {
            getUI().getNavigator().navigateTo(MainQuizzerView.VIEW_NAME);
        });

        resultLayout.addComponent(finishButton);
        resultLayout.setComponentAlignment(finishButton, Alignment.MIDDLE_CENTER);
    }

}
