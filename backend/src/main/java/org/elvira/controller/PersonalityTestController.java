package org.elvira.controller;

import org.elvira.entity.Question;
import org.elvira.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PersonalityTestController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/listQuestions")
    public ResponseEntity<Map<String, Object>> getNextQuestion() {
        try {
            List<Question> questions = questionRepository.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("questions", questions);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
