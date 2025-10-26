package org.josh.climber.repository;

import org.josh.climber.model.SessionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionModel, Long> {
    SessionModel findBySessionId(Long sessionId);
}
