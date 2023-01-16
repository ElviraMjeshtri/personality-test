package org.elvira.backend.service.result;

import org.elvira.backend.entity.quiz.PersonalityType;
import org.elvira.backend.entity.quiz.Result;

import java.util.List;

public interface ResultService {
    PersonalityType calculateTestResults(List<String> answerList);

    Result getResult(PersonalityType personalityType);
}
