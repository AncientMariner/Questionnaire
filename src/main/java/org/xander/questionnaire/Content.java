package org.xander.questionnaire;

public class Content {
    private String question;
    private String answer;

    public Content() {
        question = "default question";
        answer = "default answer";
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean exists() {
        return question != null && answer != null;
    }
}