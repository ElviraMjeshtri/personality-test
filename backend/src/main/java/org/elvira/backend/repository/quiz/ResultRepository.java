package org.elvira.backend.repository.quiz;

import org.elvira.backend.entity.quiz.PersonalityType;
import org.elvira.backend.entity.quiz.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
    Result findResultByPersonalityType(PersonalityType personalityType);

}
