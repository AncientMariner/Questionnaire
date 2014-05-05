package org.xander.questionnaire;

public class Content implements Persistent{
    private Long id;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}