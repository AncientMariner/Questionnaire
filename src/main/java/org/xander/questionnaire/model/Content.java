package org.xander.questionnaire.model;

import javax.persistence.*;

@Entity
@Table
public class Content implements Persistent {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String question;
    @Column
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