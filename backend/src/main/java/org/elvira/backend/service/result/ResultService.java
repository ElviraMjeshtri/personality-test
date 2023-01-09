package org.elvira.backend.service.result;

import org.elvira.backend.entity.PersonalityType;
import org.elvira.backend.entity.Result;

import java.util.List;

public interface ResultService {
    PersonalityType calculateTestResults(List<String> answerList);

    Result getResult(PersonalityType personalityType);
}
