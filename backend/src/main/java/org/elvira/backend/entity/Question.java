package org.elvira.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "question_id", nullable = false)
    private Long questionId;

    private String question;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "answers", joinColumns = @JoinColumn(name = "question_id"))
    private List<Answer> answerList;

}
