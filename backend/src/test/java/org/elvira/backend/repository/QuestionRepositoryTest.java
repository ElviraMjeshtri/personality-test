package org.elvira.backend.repository;

import org.elvira.backend.entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    public void testFindAll(){
        List<Question> questions = questionRepository.findAll();
        assertThat(questions).hasSize(5);
    }

    @Test
    public void testFindAllByPage(){
        Pageable paging = PageRequest.of(1, 1);
        Page<Question> pageQuestions = questionRepository.findAll(paging);
        List<Question> questions = pageQuestions.getContent();
        assertThat(questions).hasSize(1);
    }

}
