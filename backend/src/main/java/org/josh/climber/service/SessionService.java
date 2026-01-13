package org.josh.climber.service;

import jakarta.validation.Valid;
import org.josh.climber.DTO.attempt.response.AttemptResponseDTO;
import org.josh.climber.DTO.session.response.SessionDTO;
import org.josh.climber.DTOMapper.AttemptDTOMapper;
import org.josh.climber.DTOMapper.SessionDTOMapper;
import org.josh.climber.model.SessionModel;
import org.josh.climber.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Handles all operations related to Sessions
 */
@Service
public class SessionService {

    private final SessionRepository sessionRepo;
    private final SessionDTOMapper mapper;
    private final AttemptDTOMapper attemptMapper;

    public SessionService(SessionRepository sessionRepo, SessionDTOMapper mapper, AttemptDTOMapper attemptMapper) {
        this.sessionRepo = sessionRepo;
        this.mapper = mapper;
        this.attemptMapper = attemptMapper;
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

    public List<AttemptResponseDTO> getAttemptsBySessionId(Long sessionId){
        SessionModel session = sessionRepo.findBySessionId(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found: " + sessionId));

        return session.getAttempts()
                .stream()
                .map(attemptMapper::toDTO)
                .toList();
    }
}

