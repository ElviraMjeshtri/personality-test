package org.elvira.backend.service.question;

import org.elvira.backend.entity.quiz.Question;

import java.util.List;

public interface QuestionService {
   List<Question> getListOfQuestionAndAnswers();
}
