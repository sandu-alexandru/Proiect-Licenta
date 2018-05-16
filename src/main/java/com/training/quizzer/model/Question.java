package com.training.quizzer.model;

public class Question {
    private String domain;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String correct;

    public Question(){}

    public Question(String domain, String question,
                    String answer1, String answer2, String answer3, String correct) {
        this.domain = domain;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correct = correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getCorrect() {
        return correct;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getQuestion() {
        return question;
    }

    public String getDomain() {
        return domain;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

}
