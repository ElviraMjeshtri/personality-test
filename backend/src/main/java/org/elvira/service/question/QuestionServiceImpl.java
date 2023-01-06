package org.elvira.service.question;

import org.elvira.entity.Question;
import org.elvira.repository.QuestionRepository;
import org.elvira.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> getListOfQuestionAndAnswers() {
        return questionRepository.findAll();
    }
}
