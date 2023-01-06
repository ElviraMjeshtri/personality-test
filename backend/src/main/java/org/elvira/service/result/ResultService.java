package org.elvira.service.result;

import org.elvira.entity.PersonalityType;
import org.elvira.entity.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ResultService {
    public PersonalityType calculateTestResults(ArrayList<String> answerList);

    public Result getResult(PersonalityType personalityType);
}
