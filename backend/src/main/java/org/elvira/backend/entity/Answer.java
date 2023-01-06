package org.elvira.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Answer {
    private String answer;
    @Column(name = "answer_index")
    private String answerIndex;

}
