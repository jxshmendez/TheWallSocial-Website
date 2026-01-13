package org.josh.climber.controller;

import jakarta.validation.Valid;
import org.josh.climber.DTO.attempt.response.AttemptResponseDTO;
import org.josh.climber.DTO.session.response.SessionDTO;
import org.josh.climber.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<SessionDTO> getAllSessions(){
        return sessionService.getAllSessions();
    }

    @GetMapping("/{sessionId}")
    public SessionDTO findBySessionId(@PathVariable Long sessionId){
        return sessionService.findBySessionId(sessionId);
    }

    @GetMapping("/{sessionId}/attempts")
    public List<AttemptResponseDTO> getAttemptsBySessionId(@PathVariable Long sessionId){
        return sessionService.getAttemptsBySessionId(sessionId);
    }

    @PostMapping
    public SessionDTO createSession(@RequestBody SessionDTO session){
        return sessionService.createSession(session);
    }

    @PutMapping("/{sessionId}")
    public SessionDTO updateSession(@PathVariable Long sessionId, @Valid @RequestBody SessionDTO session){
        return sessionService.updateService(sessionId, session);
    }

    @DeleteMapping("/{sessionId}")
    public void deleteSession(@PathVariable Long sessionId){
        sessionService.deleteSession(sessionId);
    }
}
