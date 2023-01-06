package org.elvira.service.result;

import org.elvira.entity.PersonalityType;
import org.elvira.entity.Result;
import org.elvira.repository.ResultRepository;
import org.elvira.service.result.ResultService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;

public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Override
    public PersonalityType calculateTestResults(ArrayList<String> answerList) {
        int aOccurrences = Collections.frequency(answerList, "a");
        int bOccurrences = Collections.frequency(answerList, "b");
        int cOccurrences = Collections.frequency(answerList, "c");
        int dOccurrences = Collections.frequency(answerList, "d");
        return aOccurrences + bOccurrences >= cOccurrences+dOccurrences ? PersonalityType.INTROVERT : PersonalityType.EXTROVERT;
    }

    @Override
    public Result getResult(PersonalityType personalityType) {
        return resultRepository.findResultByPersonalityType(personalityType);
    }
}
