package org.elvira.backend.repository;

import org.elvira.backend.entity.quiz.PersonalityType;
import org.elvira.backend.entity.quiz.Result;
import org.elvira.backend.repository.quiz.ResultRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ResultRepositoryTest {
    @Autowired
    ResultRepository resultRepository;

    @Test
    public void allResult() {
        List<Result> results = resultRepository.findAll();;
        assertThat(results).hasSize(2);
    }
    @Test
    public void findResultByPersonalityType(){
        Result result  = resultRepository.findResultByPersonalityType(PersonalityType.EXTROVERT);
        assertThat(result).isNotNull();
    }
}
