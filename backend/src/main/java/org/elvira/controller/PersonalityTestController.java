package org.elvira.controller;

import org.elvira.entity.PersonalityType;
import org.elvira.service.question.QuestionService;
import org.elvira.service.result.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonalityTestController {
    @Autowired
    QuestionService questionService;
    @Autowired
    ResultService resultService;

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

    @GetMapping("/getResult/{answerIndexes}")
    public ResponseEntity<Map<String, Object>> getPersonalityResult(@PathVariable String[] answerIndexes) {
        try {
            Map<String, Object> response = new HashMap<>();
            PersonalityType personalityType = resultService.calculateTestResults((ArrayList<String>) Arrays.asList(answerIndexes));
            response.put("result", resultService.getResult(personalityType));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
