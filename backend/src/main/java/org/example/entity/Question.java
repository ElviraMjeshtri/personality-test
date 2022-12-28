package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "question_id", nullable = false)
    private Long questionId;

    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
