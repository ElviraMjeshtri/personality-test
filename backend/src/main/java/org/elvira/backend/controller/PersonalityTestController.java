package org.elvira.backend.controller;

import lombok.RequiredArgsConstructor;
import org.elvira.backend.entity.quiz.PersonalityType;
import org.elvira.backend.service.question.QuestionService;
import org.elvira.backend.service.result.ResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonalityTestController {

    private final QuestionService questionService;
    private final ResultService resultService;

    @GetMapping("/questions")
    public ResponseEntity<Map<String, Object>> getNextQuestion() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("questions", questionService.getListOfQuestionAndAnswers());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getResult/{answers}")
    public ResponseEntity<Map<String, Object>> getPersonalityResult(@PathVariable String[] answers) {
        try {
            Map<String, Object> response = new HashMap<>();
            List<String> answersList = Arrays.asList(answers);
            PersonalityType personalityType = resultService.calculateTestResults(answersList);
            response.put("result", resultService.getResult(personalityType));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
