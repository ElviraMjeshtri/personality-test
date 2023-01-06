package org.elvira.service.question;

import org.elvira.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
   List<Question> getListOfQuestionAndAnswers();
}
