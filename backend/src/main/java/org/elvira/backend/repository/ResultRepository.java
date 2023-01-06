package org.elvira.backend.repository;

import org.elvira.backend.entity.PersonalityType;
import org.elvira.backend.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
    Result findResultByPersonalityType(PersonalityType personalityType);

}
