package org.josh.climber.repository;

import org.josh.climber.model.SessionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<SessionModel, Long> {
    Optional<SessionModel> findBySessionId(Long sessionId);
}
