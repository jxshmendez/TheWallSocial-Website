package org.josh.climber.service;

import org.josh.climber.DTO.SessionDTO;
import org.josh.climber.DTOMapper.SessionDTOMapper;
import org.josh.climber.model.SessionModel;
import org.josh.climber.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepo;
    private final SessionDTOMapper mapper;

    public SessionService(SessionRepository sessionRepo, SessionDTOMapper mapper) {
        this.sessionRepo = sessionRepo;
        this.mapper = mapper;
    }

    public SessionDTO findBySessionId(Long sessionId){
        SessionModel session = sessionRepo.findBySessionId(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found: " + sessionId));
        return mapper.toDTO(session);
    }

    public List<SessionDTO> getAllSessions(){
        return sessionRepo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public SessionModel createSession(SessionModel session){
        return sessionRepo.save(session);
    }
}

