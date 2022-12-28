package org.example.controller;

import org.example.entity.Question;
import org.example.repository.AnswerRepository;
import org.example.repository.QuestionRepository;
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

    @Autowired
    AnswerRepository answerRepository;

    @GetMapping("/nextQuestion")
    public ResponseEntity<Map<String, Object>> getNextQuestion(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size
    ) {
        try {
            Pageable paging = PageRequest.of(page, size);
            Page<Question> pageQuestions = questionRepository.findAll(paging);
            List<Question> questions = pageQuestions.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("questions", questions);
            response.put("currentPage", pageQuestions.getNumber());
            response.put("totalItems", pageQuestions.getTotalElements());
            response.put("totalPages", pageQuestions.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
