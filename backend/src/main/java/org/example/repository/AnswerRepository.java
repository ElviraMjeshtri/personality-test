package org.example.repository;

import org.example.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository  extends JpaRepository<Answer, Long> {
}
