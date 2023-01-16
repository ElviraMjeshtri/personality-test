package org.elvira.backend.service.result;

import org.elvira.backend.entity.quiz.PersonalityType;
import org.elvira.backend.entity.quiz.Result;
import org.elvira.backend.repository.quiz.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Override
    public PersonalityType calculateTestResults(List<String> answerList) {
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
