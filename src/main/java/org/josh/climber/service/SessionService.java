package org.josh.climber.service;

import jakarta.validation.Valid;
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

    public SessionDTO createSession(SessionDTO dto){
        SessionModel session = mapper.toEntity(dto);
        SessionModel saved = sessionRepo.save(session);
        return mapper.toDTO(saved);
    }

    public SessionDTO updateService(Long sessionId, @Valid SessionDTO session) {
        SessionModel existing = sessionRepo.findBySessionId(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found: " + sessionId));

        existing.setSessionDate(session.sessionDate());
        existing.setDurationMinutes(session.durationMinutes());
        existing.setNotes(session.notes());
        SessionModel updated = sessionRepo.save(existing);
        return mapper.toDTO(updated);
    }

    public void deleteSession(Long sessionId) {
        if(!sessionRepo.existsById(sessionId)){
            throw new RuntimeException("Session not found: " + sessionId);
        }
    }
}

