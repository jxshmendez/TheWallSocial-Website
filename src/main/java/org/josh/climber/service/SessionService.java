package org.josh.climber.service;

import org.josh.climber.model.SessionModel;
import org.josh.climber.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepo;

    public SessionService(SessionRepository sessionRepo) {
        this.sessionRepo = sessionRepo;
    }

    public List<SessionModel> getAllSessions(){
        return sessionRepo.findAll();
    }

    public SessionModel createSession(SessionModel session){
        return sessionRepo.save(session);
    }
}

