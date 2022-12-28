package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "answer_id", nullable = false)
    private Long answerId;
    private Long questionId;

    private String answer;
    private int precedence;
    private int points;

    public String getAnswer() {
        return answer;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
}
