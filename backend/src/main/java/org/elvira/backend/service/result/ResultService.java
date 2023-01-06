package org.elvira.backend.service.result;

import org.elvira.backend.entity.PersonalityType;
import org.elvira.backend.entity.Result;

import java.util.ArrayList;

public interface ResultService {
    public PersonalityType calculateTestResults(ArrayList<String> answerList);

    public Result getResult(PersonalityType personalityType);
}
