package org.elvira.backend.service.question;

import org.elvira.backend.entity.quiz.Question;
import org.elvira.backend.repository.quiz.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> getListOfQuestionAndAnswers() {
        return questionRepository.findAll();
    }
}
