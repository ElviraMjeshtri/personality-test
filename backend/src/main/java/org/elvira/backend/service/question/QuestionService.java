package org.elvira.backend.service.question;

import org.elvira.backend.entity.Question;

import java.util.List;

public interface QuestionService {
   List<Question> getListOfQuestionAndAnswers();
}
