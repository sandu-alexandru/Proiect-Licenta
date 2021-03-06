package com.training.quizzer.ui.view;

import com.training.quizzer.model.*;
import com.training.quizzer.repository.DomainRepository;
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

@SpringView(name = AdminView.VIEW_NAME)
public class AdminView extends HorizontalLayout implements View{
    public static final String VIEW_NAME = "adminView";
    public static final int NUMBER_OF_QUESTIONS_SUPPORTED_FOR_EDITING = 1;
    public User user;

    @Autowired
    UserService userService;

    @Autowired
    LevelService levelService;

    @Autowired
    DomainRepository domainRepository;

    ArrayList<CheckBox> domains;
    ArrayList<CheckBox> questions;
    VerticalLayout manageDomainsLayout;
    VerticalLayout domainsLayout;
    VerticalLayout manageQuestionsLayout;
    VerticalLayout questionsLayout;
    ComboBox<String> levelsComboBox;
    ComboBox<String> domainsComboBox;


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @PostConstruct
    private void init() {
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        setComponents();
    }

    private void setComponents() {
        setDomainManagementLayout();
        setQuestionManagementLayout();
    }

    private void setDomainManagementLayout() {
        manageDomainsLayout = new VerticalLayout();
        domainsLayout = new VerticalLayout();
        domains = new ArrayList<>();
        questions = new ArrayList<>();
        manageDomainsLayout.addComponents(new Label("Quizzer Domains:"));
        setDomainsLayout();
        manageDomainsLayout.addComponents(domainsLayout);
        setDomainButtonsLayout();
        addComponent(manageDomainsLayout);
    }

    private void setDomainButtonsLayout() {
        Button deleteDomainButton = new Button("Delete Domain");
        deleteDomainButton.setWidth("150");
        deleteDomainButton.addClickListener(clickEvent -> {
            prepareDeleteDomainConfirmation();
        });
        manageDomainsLayout.addComponent(deleteDomainButton);

        HorizontalLayout createDomainLayout = new HorizontalLayout();
        TextField domainName = new TextField();
        domainName.setWidth("150");
        Button createDomainButton = new Button("Create Domain");
        createDomainButton.setWidth("150");
        createDomainButton.addClickListener(clickEvent -> {
            if(domainName.isEmpty()){
                Notification.show("Please enter a name for the new domain!", Notification.Type.WARNING_MESSAGE);
            } else {
                Domain toBeSaved = new Domain();
                toBeSaved.setName(domainName.getValue());
                domainRepository.save(toBeSaved);
                setDomainsLayout();
                domainName.clear();
            }
        });

        createDomainLayout.addComponents(createDomainButton, domainName);
        manageDomainsLayout.addComponents(new Label(""));
        manageDomainsLayout.addComponent(createDomainLayout);
    }

    private void prepareDeleteDomainConfirmation() {
        Window confirmDeleteDomainWindow = new Window("Delete Domain Confirmation");
        VerticalLayout confirmDeleteDomainLayout = new VerticalLayout();
        confirmDeleteDomainLayout.addComponent(new Label("Are you sure that you want to delete these domains ?"));
        HorizontalLayout confirmButtonsLayout = new HorizontalLayout();

        Button confirmDeleteButton = new Button("Confirm");
        confirmDeleteButton.setWidth("150");
        Button cancelDeleteButton = new Button("Cancel");
        cancelDeleteButton.setWidth("150");

        cancelDeleteButton.addClickListener(event->{confirmDeleteDomainWindow.close();});
        confirmDeleteButton.addClickListener(event->{
            deteleDomains();
            confirmDeleteDomainWindow.close();
        });
        confirmButtonsLayout.addComponents(confirmDeleteButton,cancelDeleteButton);
        confirmDeleteDomainLayout.addComponent(confirmButtonsLayout);
        confirmDeleteDomainWindow.setContent(confirmDeleteDomainLayout);
        getUI().addWindow(confirmDeleteDomainWindow);
        confirmDeleteDomainWindow.center();
    }

    private void deteleDomains() {
        domains.forEach(domain->{
            if(domain.getValue()){
                Domain toBeDeleted = domainRepository.getDomainByName(domain.getCaption());
                domainRepository.delete(toBeDeleted);
            }});
        setDomainsLayout();
    }

    private void setDomainsLayout() {
        domainsLayout.removeAllComponents();
        domains.clear();
        domainRepository.getDomains().forEach(domain->{
            CheckBox current = new CheckBox(domain);
            domains.add(current);
        });
        domains.forEach(domain -> {domainsLayout.addComponent(domain);});
    }

    private void setQuestionManagementLayout() {
        manageQuestionsLayout = new VerticalLayout();
        manageQuestionsLayout.addComponent(new Label("Quizzer Questions: "));
//        manageQuestionsLayout.addComponent(new Label(""));

        levelsComboBox = new ComboBox<>();
        levelsComboBox.setEmptySelectionAllowed(false);
        levelsComboBox.setTextInputAllowed(false);
        levelsComboBox.setItems(getLevels());

        domainsComboBox = new ComboBox<>();
        domainsComboBox.setEmptySelectionAllowed(false);
        domainsComboBox.setTextInputAllowed(false);
        domainsComboBox.setItems(getDomains());

        HorizontalLayout levelsAndDomainsLayout = new HorizontalLayout();
        levelsAndDomainsLayout.addComponents(levelsComboBox, domainsComboBox);
        manageQuestionsLayout.addComponent(levelsAndDomainsLayout);

        questionsLayout = new VerticalLayout();
        Panel questionsPanel = new Panel();
        questionsPanel.setWidth("380");
        questionsPanel.setHeight("170");
        questionsPanel.setContent(questionsLayout);
        levelsComboBox.addValueChangeListener(valueChangeEvent -> {
            setQuestionsLayout(levelsComboBox.getValue(), domainsComboBox.getValue());
        });
        domainsComboBox.addValueChangeListener(valueChangeEvent -> {
            setQuestionsLayout(levelsComboBox.getValue(), domainsComboBox.getValue());
        });
        levelsComboBox.setValue("Level 1");
        domainsComboBox.setValue("BIOLOGY");
        manageQuestionsLayout.addComponent(questionsPanel);

        Button deleteQuestionsButton = new Button("Delete Question");
        deleteQuestionsButton.setWidth("150");
        deleteQuestionsButton.addClickListener(clickEvent -> {
            prepareDeleteQuestionConfirmation();
        });
        HorizontalLayout deleteAndEditButtonsLayout = new HorizontalLayout();
        Button editQuestionButton = new Button("Edit Question");
        editQuestionButton.setWidth("150");
        editQuestionButton.addClickListener(event->{
            handleQuestionEditing();
        });

        deleteAndEditButtonsLayout.addComponents(deleteQuestionsButton, editQuestionButton);
        manageQuestionsLayout.addComponent(deleteAndEditButtonsLayout);
//        manageQuestionsLayout.addComponent(deleteQuestionsButton);

        manageQuestionsLayout.addComponent(new Label());
        manageQuestionsLayout.addComponent(new Label("Add a new question: "));

        ComboBox<String> questionDomains = new ComboBox<>();
        questionDomains.setWidth("200");
        questionDomains.setItems(getDomains());
        ComboBox<String> questionLevels = new ComboBox<>();
        questionLevels.setWidth("200");
        questionLevels.setItems(getLevels());

        HorizontalLayout questionDomainAndLevel = new HorizontalLayout();
        questionDomainAndLevel.addComponents(questionLevels, questionDomains);
        manageQuestionsLayout.addComponent(questionDomainAndLevel);

        TextField questionText = new TextField();
        questionText.setWidth("400");
        questionText.setPlaceholder("Question ...");
        manageQuestionsLayout.addComponent(questionText);

        HorizontalLayout responsesLayout = new HorizontalLayout();
        VerticalLayout textResponsesLayout = new VerticalLayout();
        VerticalLayout correctResponseLayout = new VerticalLayout();

        TextField questionAnswer1 = new TextField();
        questionAnswer1.setWidth("200");
        questionAnswer1.setPlaceholder("First answer ...");

        TextField questionAnswer2 = new TextField();
        questionAnswer2.setWidth("200");
        questionAnswer2.setPlaceholder("Second answer ...");

        TextField questionAnswer3 = new TextField();
        questionAnswer3.setWidth("200");
        questionAnswer3.setPlaceholder("Third answer ...");

        RadioButtonGroup<String> correctResponsesGroup = new RadioButtonGroup<>();
        correctResponsesGroup.setItems("A", "B", "C");

        correctResponseLayout.addComponent(correctResponsesGroup);
        textResponsesLayout.addComponents(questionAnswer1, questionAnswer2, questionAnswer3);

        responsesLayout.addComponents(textResponsesLayout, correctResponseLayout);
        manageQuestionsLayout.addComponent(responsesLayout);

//        manageQuestionsLayout.addComponent(correctResponseLayout);

//        HorizontalLayout questionAnswers = new HorizontalLayout();
//        questionAnswers.addComponents(questionAnswer1, questionAnswer2, questionAnswer3);
//        manageQuestionsLayout.addComponent(questionAnswers);

//        TextField questionCorrect = new TextField();
//        questionCorrect.setWidth("200");
//        questionCorrect.setPlaceholder("Correct answer ...");
//        manageQuestionsLayout.addComponent(questionCorrect);
            
        
        
        Button addQuestion = new Button("Add Question");
        addQuestion.setWidth("200");
        addQuestion.addClickListener(clickEvent -> {
            String level = questionLevels.getValue();
            String response = getResponseSelection(correctResponsesGroup, questionAnswer1.getValue(), 
                    questionAnswer2.getValue(), questionAnswer3.getValue());
            if (level.equals("Level 1")){
                Level1 toBeAdded = new Level1();

                toBeAdded.setDomain(questionDomains.getValue());
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level1Repository.save(toBeAdded);

            } else if (level.equals("Level 2")){
                Level2 toBeAdded = new Level2();

                toBeAdded.setDomain(questionDomains.getValue());
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level2Repository.save(toBeAdded);

            } else if (level.equals("Level 3")){
                Level3 toBeAdded = new Level3();

                toBeAdded.setDomain(questionDomains.getValue());
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level3Repository.save(toBeAdded);

            } else if (level.equals("Level 4")){
                Level4 toBeAdded = new Level4();

                toBeAdded.setDomain(questionDomains.getValue());
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level4Repository.save(toBeAdded);

            } else if (level.equals("Level 5")){
                Level5 toBeAdded = new Level5();

                toBeAdded.setDomain(questionDomains.getValue());
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level5Repository.save(toBeAdded);

            } else if (level.equals("Level 6")){
                Level6 toBeAdded = new Level6();

                toBeAdded.setDomain(questionDomains.getValue());
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level6Repository.save(toBeAdded);

            } else if (level.equals("Level 7")){
                Level7 toBeAdded = new Level7();

                toBeAdded.setDomain(questionDomains.getValue());
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level7Repository.save(toBeAdded);

            }

            questionText.clear();
            questionAnswer1.clear();
            questionAnswer2.clear();
            questionAnswer3.clear();
//            questionCorrect.clear();

            setQuestionsLayout(levelsComboBox.getValue(), domainsComboBox.getValue());
        });
        manageQuestionsLayout.addComponent(addQuestion);

        addComponent(manageQuestionsLayout);
    }

    private void prepareDeleteQuestionConfirmation() {
        Window confirmDeleteQuestionWindow = new Window("Delete Question Confirmation");
        VerticalLayout confirmDeleteQuestionLayout = new VerticalLayout();
        confirmDeleteQuestionLayout.addComponent(new Label("Are you sure that you want to delete these questions ?"));
        HorizontalLayout confirmButtonsLayout = new HorizontalLayout();
        
        Button confirmDeleteButton = new Button("Confirm");
        confirmDeleteButton.setWidth("150");
        Button cancelDeleteButton = new Button("Cancel");
        cancelDeleteButton.setWidth("150");
        
        cancelDeleteButton.addClickListener(event->{confirmDeleteQuestionWindow.close();});
        confirmDeleteButton.addClickListener(event->{
            deleteQuestion();
            confirmDeleteQuestionWindow.close();
        });
        confirmButtonsLayout.addComponents(confirmDeleteButton,cancelDeleteButton);
        confirmDeleteQuestionLayout.addComponent(confirmButtonsLayout);
        confirmDeleteQuestionWindow.setContent(confirmDeleteQuestionLayout);
        getUI().addWindow(confirmDeleteQuestionWindow);
        confirmDeleteQuestionWindow.center();
    }

    private void deleteQuestion() {
        String level = levelsComboBox.getValue();
        questions.forEach( question -> {
            if(question.getValue()){
                if (level.equals("Level 1")){
                    Level1 toBeDeleted = levelService.level1Repository.getQuestionByQuestion(question.getCaption());
                    levelService.level1Repository.delete(toBeDeleted);
                } else if (level.equals("Level 2")){
                    Level2 toBeDeleted = levelService.level2Repository.getQuestionByQuestion(question.getCaption());
                    levelService.level2Repository.delete(toBeDeleted);
                } else if (level.equals("Level 3")){
                    Level3 toBeDeleted = levelService.level3Repository.getQuestionByQuestion(question.getCaption());
                    levelService.level3Repository.delete(toBeDeleted);
                } else if (level.equals("Level 4")){
                    Level4 toBeDeleted = levelService.level4Repository.getQuestionByQuestion(question.getCaption());
                    levelService.level4Repository.delete(toBeDeleted);
                } else if (level.equals("Level 5")){
                    Level5 toBeDeleted = levelService.level5Repository.getQuestionByQuestion(question.getCaption());
                    levelService.level5Repository.delete(toBeDeleted);
                } else if (level.equals("Level 6")){
                    Level6 toBeDeleted = levelService.level6Repository.getQuestionByQuestion(question.getCaption());
                    levelService.level6Repository.delete(toBeDeleted);
                } else if (level.equals("Level 7")){
                    Level7 toBeDeleted = levelService.level7Repository.getQuestionByQuestion(question.getCaption());
                    levelService.level7Repository.delete(toBeDeleted);
                }
            }});
        setQuestionsLayout(levelsComboBox.getValue(), domainsComboBox.getValue());
    }

    private void handleQuestionEditing() {
        int selectedValues = 0;
        for(CheckBox question : questions)
            if (question.getValue())
                selectedValues++;
        if (selectedValues == NUMBER_OF_QUESTIONS_SUPPORTED_FOR_EDITING) {
            prepareEditingQuestionWindow();
        } else if (selectedValues > NUMBER_OF_QUESTIONS_SUPPORTED_FOR_EDITING) {
            warnUserForMultipleQuestionsSelected();
        } else if (selectedValues < NUMBER_OF_QUESTIONS_SUPPORTED_FOR_EDITING) {
            warnUserToSelectAQuestion();
        }

    }

    private void warnUserToSelectAQuestion() {
        Notification.show("Please select one question to edit ", Notification.Type.WARNING_MESSAGE);
    }

    private void warnUserForMultipleQuestionsSelected() {
        Notification.show("Multiple Questions selected, can't edit more than "
                        + NUMBER_OF_QUESTIONS_SUPPORTED_FOR_EDITING + " at once"
                , Notification.Type.WARNING_MESSAGE);
    }

    private void prepareEditingQuestionWindow() {
        VerticalLayout editQuestionLayoutContent = new VerticalLayout();

        Window editQuestionWindow = new Window("Edit Question");
        editQuestionWindow.setContent(editQuestionLayoutContent);

//        ComboBox<String> questionDomains = new ComboBox<>();
//        questionDomains.setWidth("200");
//        questionDomains.setItems(getDomains());
//        ComboBox<String> questionLevels = new ComboBox<>();
//        questionLevels.setWidth("200");
//        questionLevels.setItems(getLevels());
//
//        HorizontalLayout questionDomainAndLevel = new HorizontalLayout();
//        questionDomainAndLevel.addComponents(questionLevels, questionDomains);
//        editQuestionLayoutContent.addComponent(questionDomainAndLevel);

        TextField questionText = new TextField();
        questionText.setWidth("400");
        questionText.setPlaceholder("Question ...");
        editQuestionLayoutContent.addComponent(questionText);

        HorizontalLayout responsesLayout = new HorizontalLayout();
        VerticalLayout textResponsesLayout = new VerticalLayout();
        VerticalLayout correctResponseLayout = new VerticalLayout();

        TextField questionAnswer1 = new TextField();
        questionAnswer1.setWidth("200");
        questionAnswer1.setPlaceholder("First answer ...");

        TextField questionAnswer2 = new TextField();
        questionAnswer2.setWidth("200");
        questionAnswer2.setPlaceholder("Second answer ...");

        TextField questionAnswer3 = new TextField();
        questionAnswer3.setWidth("200");
        questionAnswer3.setPlaceholder("Third answer ...");

        RadioButtonGroup<String> correctResponsesGroup = new RadioButtonGroup<>();
        correctResponsesGroup.setItems("A", "B", "C");

        correctResponseLayout.addComponent(correctResponsesGroup);
        textResponsesLayout.addComponents(questionAnswer1, questionAnswer2, questionAnswer3);

        responsesLayout.addComponents(textResponsesLayout, correctResponseLayout);
        editQuestionLayoutContent.addComponent(responsesLayout);

        Button saveChangesButton = new Button("Save");
        saveChangesButton.setWidth("150");
        Button cancelChangesButton = new Button("Cancel");
        cancelChangesButton.setWidth("150");

        HorizontalLayout saveAndCancelButtonslayout = new HorizontalLayout();
        saveAndCancelButtonslayout.addComponents(saveChangesButton, cancelChangesButton);
        editQuestionLayoutContent.addComponents(saveAndCancelButtonslayout);

        String questionCapt="";
        String level = levelsComboBox.getValue();
        for(CheckBox question : questions)
            if (question.getValue())
                questionCapt = question.getCaption();
        final String questionCaption = questionCapt;

        if (level.equals("Level 1")){
            Level1 toBeEdited = levelService.level1Repository.getQuestionByQuestion(questionCaption);
            questionText.setValue(questionCaption);
            questionAnswer1.setValue(toBeEdited.getAnswer1());
            questionAnswer2.setValue(toBeEdited.getAnswer2());
            questionAnswer3.setValue(toBeEdited.getAnswer3());
            if (questionAnswer1.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("A");
            else if (questionAnswer2.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("B");
            else if (questionAnswer3.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("C");
        } else if (level.equals("Level 2")){
            Level2 toBeEdited = levelService.level2Repository.getQuestionByQuestion(questionCaption);
            questionText.setValue(questionCaption);
            questionAnswer1.setValue(toBeEdited.getAnswer1());
            questionAnswer2.setValue(toBeEdited.getAnswer2());
            questionAnswer3.setValue(toBeEdited.getAnswer3());
            if (questionAnswer1.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("A");
            else if (questionAnswer2.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("B");
            else if (questionAnswer3.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("C");
        } else if (level.equals("Level 3")){
            Level3 toBeEdited = levelService.level3Repository.getQuestionByQuestion(questionCaption);
            questionText.setValue(questionCaption);
            questionAnswer1.setValue(toBeEdited.getAnswer1());
            questionAnswer2.setValue(toBeEdited.getAnswer2());
            questionAnswer3.setValue(toBeEdited.getAnswer3());
            if (questionAnswer1.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("A");
            else if (questionAnswer2.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("B");
            else if (questionAnswer3.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("C");
        } else if (level.equals("Level 4")){
            Level4 toBeEdited = levelService.level4Repository.getQuestionByQuestion(questionCaption);
            questionText.setValue(questionCaption);
            questionAnswer1.setValue(toBeEdited.getAnswer1());
            questionAnswer2.setValue(toBeEdited.getAnswer2());
            questionAnswer3.setValue(toBeEdited.getAnswer3());
            if (questionAnswer1.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("A");
            else if (questionAnswer2.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("B");
            else if (questionAnswer3.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("C");
        } else if (level.equals("Level 5")){
            Level5 toBeEdited = levelService.level5Repository.getQuestionByQuestion(questionCaption);
            questionText.setValue(questionCaption);
            questionAnswer1.setValue(toBeEdited.getAnswer1());
            questionAnswer2.setValue(toBeEdited.getAnswer2());
            questionAnswer3.setValue(toBeEdited.getAnswer3());
            if (questionAnswer1.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("A");
            else if (questionAnswer2.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("B");
            else if (questionAnswer3.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("C");
        } else if (level.equals("Level 6")){
            Level6 toBeEdited = levelService.level6Repository.getQuestionByQuestion(questionCaption);
            questionText.setValue(questionCaption);
            questionAnswer1.setValue(toBeEdited.getAnswer1());
            questionAnswer2.setValue(toBeEdited.getAnswer2());
            questionAnswer3.setValue(toBeEdited.getAnswer3());
            if (questionAnswer1.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("A");
            else if (questionAnswer2.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("B");
            else if (questionAnswer3.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("C");
        } else if (level.equals("Level 7")){
            Level7 toBeEdited = levelService.level7Repository.getQuestionByQuestion(questionCaption);
            questionText.setValue(questionCaption);
            questionAnswer1.setValue(toBeEdited.getAnswer1());
            questionAnswer2.setValue(toBeEdited.getAnswer2());
            questionAnswer3.setValue(toBeEdited.getAnswer3());
            if (questionAnswer1.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("A");
            else if (questionAnswer2.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("B");
            else if (questionAnswer3.getValue().equals(toBeEdited.getCorrect()))
                correctResponsesGroup.setSelectedItem("C");
        }



        cancelChangesButton.addClickListener(event->{editQuestionWindow.close();});
        saveChangesButton.addClickListener(event->{
            String response = getResponseSelection(correctResponsesGroup, questionAnswer1.getValue(),
                    questionAnswer2.getValue(), questionAnswer3.getValue());
            if (level.equals("Level 1")){
                Level1 toBeAdded = levelService.level1Repository.getQuestionByQuestion(questionCaption);
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level1Repository.save(toBeAdded);

            } else if (level.equals("Level 2")){
                Level2 toBeAdded = levelService.level2Repository.getQuestionByQuestion(questionCaption);
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level2Repository.save(toBeAdded);

            } else if (level.equals("Level 3")){
                Level3 toBeAdded = levelService.level3Repository.getQuestionByQuestion(questionCaption);
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level3Repository.save(toBeAdded);

            } else if (level.equals("Level 4")){
                Level4 toBeAdded = levelService.level4Repository.getQuestionByQuestion(questionCaption);
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level4Repository.save(toBeAdded);

            } else if (level.equals("Level 5")){
                Level5 toBeAdded = levelService.level5Repository.getQuestionByQuestion(questionCaption);
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level5Repository.save(toBeAdded);

            } else if (level.equals("Level 6")){
                Level6 toBeAdded = levelService.level6Repository.getQuestionByQuestion(questionCaption);
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level6Repository.save(toBeAdded);

            } else if (level.equals("Level 7")){
                Level7 toBeAdded = levelService.level7Repository.getQuestionByQuestion(questionCaption);
                toBeAdded.setQuestion(questionText.getValue());
                toBeAdded.setAnswer1(questionAnswer1.getValue());
                toBeAdded.setAnswer2(questionAnswer2.getValue());
                toBeAdded.setAnswer3(questionAnswer3.getValue());
                toBeAdded.setCorrect(response);

                levelService.level7Repository.save(toBeAdded);

            }

            setQuestionsLayout(levelsComboBox.getValue(), domainsComboBox.getValue());
            editQuestionWindow.close();
        });

        editQuestionWindow.center();
        getUI().addWindow(editQuestionWindow);

//        PopupView editQuestionPopup = new PopupView("Edit Question", editQuestionLayoutContent);
//        editQuestionPopup.setPopupVisible(true);
    }

    private String getResponseSelection(RadioButtonGroup responseGroup, String answer1, String answer2, String answer3) {
        if(responseGroup.getSelectedItem().toString().contains("A"))
            return answer1;
        else if(responseGroup.getSelectedItem().toString().contains("B"))
            return answer2;
        else if(responseGroup.getSelectedItem().toString().contains("C"))
            return answer3;
        else return "no selection";
    }

    private void setQuestionsLayout(String level, String domain) {
        questionsLayout.removeAllComponents();
        questions.clear();
        if (level.equals("Level 1")){
            levelService.level1Repository.getLevel1QuestionsByDomain(domain).forEach(question->{
                CheckBox current = new CheckBox(question.getQuestion());
                questions.add(current);
            });
        } else if (level.equals("Level 2")){
            levelService.level2Repository.getLevel2QuestionsByDomain(domain).forEach(question->{
                CheckBox current = new CheckBox(question.getQuestion());
                questions.add(current);
            });
        } else if (level.equals("Level 3")){
            levelService.level3Repository.getLevel3QuestionsByDomain(domain).forEach(question->{
                CheckBox current = new CheckBox(question.getQuestion());
                questions.add(current);
            });
        } else if (level.equals("Level 4")){
            levelService.level4Repository.getLevel4QuestionsByDomain(domain).forEach(question->{
                CheckBox current = new CheckBox(question.getQuestion());
                questions.add(current);
            });
        } else if (level.equals("Level 5")){
            levelService.level5Repository.getLevel5QuestionsByDomain(domain).forEach(question->{
                CheckBox current = new CheckBox(question.getQuestion());
                questions.add(current);
            });
        } else if (level.equals("Level 6")){
            levelService.level6Repository.getLevel6QuestionsByDomain(domain).forEach(question->{
                CheckBox current = new CheckBox(question.getQuestion());
                questions.add(current);
            });
        } else if (level.equals("Level 7")){
            levelService.level7Repository.getLevel7QuestionsByDomain(domain).forEach(question->{
                CheckBox current = new CheckBox(question.getQuestion());
                questions.add(current);
            });
        }
        questions.forEach(question -> {questionsLayout.addComponent(question);});
    }

    private List<String> getLevels(){
        List<String> levels = new ArrayList<>();
        levels.add("Level 1");
        levels.add("Level 2");
        levels.add("Level 3");
        levels.add("Level 4");
        levels.add("Level 5");
        levels.add("Level 6");
        levels.add("Level 7");
        return levels;
    }

    private List<String> getDomains(){
        List<String> domains = domainRepository.getDomains();
        return domains;
    }

}
