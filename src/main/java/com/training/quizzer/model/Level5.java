package com.training.quizzer.model;

import javax.persistence.*;

@Entity
public class Level5 {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "domain")
    private String domain;

    @Column(name = "question")
    private String question;

    @Column(name = "answer1")
    private String answer1;

    @Column(name = "answer2")
    private String answer2;

    @Column(name = "answer3")
    private String answer3;

    @Column(name = "correct")
    private String correct;

    public Long getId() {
        return id;
    }

    public String getDomain() {
        return domain;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getCorrect() {
        return correct;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }


    @Override
    public String toString() {
        return "-- Level 2 [ " +  "id=" + id + ", domain=" + domain + ", question=" + question
                + ", answer1 = " + answer1 + ", answer2 = " + answer2 +
                ", answer3 = " + answer3 + ", correct = " + correct + " ]";
    }
}