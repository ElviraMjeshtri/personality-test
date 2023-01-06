package org.elvira.repository;

import org.elvira.entity.PersonalityType;
import org.elvira.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
    Result findResultByPersonalityType(PersonalityType personalityType);

}
