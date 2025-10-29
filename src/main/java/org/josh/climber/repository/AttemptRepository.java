package org.josh.climber.repository;

import org.josh.climber.model.AttemptModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptRepository extends JpaRepository<AttemptModel, Long>{
        AttemptModel findByAttemptId(Long attemptId);
}

