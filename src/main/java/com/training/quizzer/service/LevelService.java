package com.training.quizzer.service;

import com.training.quizzer.model.*;
import com.training.quizzer.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
public class LevelService {
    private static final Logger logger = Logger.getLogger(LevelService.class.getName());

    // preparing repositories
    @Autowired
    public Level1Repository level1Repository;
    @Autowired
    public Level2Repository level2Repository;
    @Autowired
    public Level3Repository level3Repository;
    @Autowired
    public Level4Repository level4Repository;
    @Autowired
    public Level5Repository level5Repository;
    @Autowired
    public Level6Repository level6Repository;
    @Autowired
    public Level7Repository level7Repository;

    public Level1Repository getLevel1Repository() {
        return level1Repository;
    }

    public Level2Repository getLevel2Repository() {
        return level2Repository;
    }

    public Level3Repository getLevel3Repository() {
        return level3Repository;
    }

    public Level4Repository getLevel4Repository() {
        return level4Repository;
    }

    public Level5Repository getLevel5Repository() {
        return level5Repository;
    }

    public Level6Repository getLevel6Repository() {
        return level6Repository;
    }

    public Level7Repository getLevel7Repository() {
        return level7Repository;
    }

//    public List<Level1> getLevel1Questions(int limitOfQuestions, User.Domain domain) {
    public List<Level1> getLevel1Questions(int limitOfQuestions, String domain) {
//        List<Level1> allQuestions = level1Repository.findAll(); // getting all questions
        List<Level1> allQuestions = level1Repository.getLevel1QuestionsByDomain(domain.toString()); // getting all questions
        Collections.shuffle(allQuestions); // mixing them up in a random order
        if (limitOfQuestions == 0) { // if the limit number is 0 (zero)
            return allQuestions; // return the whole list
        } else {
            List<Level1> level1Questions = new ArrayList<>();
            for (int i = 0; i < limitOfQuestions; i++) { // else, add only the number
                level1Questions.add(allQuestions.get(i)); //specified by the limit
            }
            return level1Questions; // return the desired list
        }
    }

//    public List<Level2> getLevel2Questions(int limitOfQuestions, User.Domain domain) {
    public List<Level2> getLevel2Questions(int limitOfQuestions, String domain) {
//        List<Level1> allQuestions = level1Repository.findAll(); // getting all questions
        List<Level2> allQuestions = level2Repository.getLevel2QuestionsByDomain(domain.toString()); // getting all questions
        Collections.shuffle(allQuestions); // mixing them up in a random order
        if (limitOfQuestions == 0) { // if the limit number is 0 (zero)
            return allQuestions; // return the whole list
        } else {
            List<Level2> level2Questions = new ArrayList<>();
            for (int i = 0; i < limitOfQuestions; i++) { // else, add only the number
                level2Questions.add(allQuestions.get(i)); //specified by the limit
            }
            return level2Questions; // return the desired list
        }
    }

//    public List<Level3> getLevel3Questions(int limitOfQuestions, User.Domain domain) {
    public List<Level3> getLevel3Questions(int limitOfQuestions, String domain) {
//        List<Level1> allQuestions = level1Repository.findAll(); // getting all questions
        List<Level3> allQuestions = level3Repository.getLevel3QuestionsByDomain(domain.toString()); // getting all questions
        Collections.shuffle(allQuestions); // mixing them up in a random order
        if (limitOfQuestions == 0) { // if the limit number is 0 (zero)
            return allQuestions; // return the whole list
        } else {
            List<Level3> level3Questions = new ArrayList<>();
            for (int i = 0; i < limitOfQuestions; i++) { // else, add only the number
                level3Questions.add(allQuestions.get(i)); //specified by the limit
            }
            return level3Questions; // return the desired list
        }
    }

//    public List<Level4> getLevel4Questions(int limitOfQuestions, User.Domain domain) {
    public List<Level4> getLevel4Questions(int limitOfQuestions, String domain) {
//        List<Level1> allQuestions = level1Repository.findAll(); // getting all questions
        List<Level4> allQuestions = level4Repository.getLevel4QuestionsByDomain(domain.toString()); // getting all questions
        Collections.shuffle(allQuestions); // mixing them up in a random order
        if (limitOfQuestions == 0) { // if the limit number is 0 (zero)
            return allQuestions; // return the whole list
        } else {
            List<Level4> level4Questions = new ArrayList<>();
            for (int i = 0; i < limitOfQuestions; i++) { // else, add only the number
                level4Questions.add(allQuestions.get(i)); //specified by the limit
            }
            return level4Questions; // return the desired list
        }
    }

//    public List<Level5> getLevel5Questions(int limitOfQuestions, User.Domain domain) {
    public List<Level5> getLevel5Questions(int limitOfQuestions, String domain) {
//        List<Level1> allQuestions = level1Repository.findAll(); // getting all questions
        List<Level5> allQuestions = level5Repository.getLevel5QuestionsByDomain(domain.toString()); // getting all questions
        Collections.shuffle(allQuestions); // mixing them up in a random order
        if (limitOfQuestions == 0) { // if the limit number is 0 (zero)
            return allQuestions; // return the whole list
        } else {
            List<Level5> level5Questions = new ArrayList<>();
            for (int i = 0; i < limitOfQuestions; i++) { // else, add only the number
                level5Questions.add(allQuestions.get(i)); //specified by the limit
            }
            return level5Questions; // return the desired list
        }
    }

//    public List<Level6> getLevel6Questions(int limitOfQuestions, User.Domain domain) {
    public List<Level6> getLevel6Questions(int limitOfQuestions, String domain) {
//        List<Level1> allQuestions = level1Repository.findAll(); // getting all questions
        List<Level6> allQuestions = level6Repository.getLevel6QuestionsByDomain(domain.toString()); // getting all questions
        Collections.shuffle(allQuestions); // mixing them up in a random order
        if (limitOfQuestions == 0) { // if the limit number is 0 (zero)
            return allQuestions; // return the whole list
        } else {
            List<Level6> level6Questions = new ArrayList<>();
            for (int i = 0; i < limitOfQuestions; i++) { // else, add only the number
                level6Questions.add(allQuestions.get(i)); //specified by the limit
            }
            return level6Questions; // return the desired list
        }
    }

//    public List<Level7> getLevel7Questions(int limitOfQuestions, User.Domain domain) {
    public List<Level7> getLevel7Questions(int limitOfQuestions, String domain) {
//        List<Level1> allQuestions = level1Repository.findAll(); // getting all questions
        List<Level7> allQuestions = level7Repository.getLevel7QuestionsByDomain(domain.toString()); // getting all questions
        Collections.shuffle(allQuestions); // mixing them up in a random order
        if (limitOfQuestions == 0) { // if the limit number is 0 (zero)
            return allQuestions; // return the whole list
        } else {
            List<Level7> level7Questions = new ArrayList<>();
            for (int i = 0; i < limitOfQuestions; i++) { // else, add only the number
                level7Questions.add(allQuestions.get(i)); //specified by the limit
            }
            return level7Questions; // return the desired list
        }
    }
}
