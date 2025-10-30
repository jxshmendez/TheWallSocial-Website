package org.josh.climber.repository;

import org.josh.climber.model.AttemptModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttemptRepository extends JpaRepository<AttemptModel, Long>{
        Optional<AttemptModel> findByAttemptId(Long attemptId);
}

