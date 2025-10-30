package org.josh.climber.controller;

import org.josh.climber.DTO.SessionDTO;
import org.josh.climber.model.SessionModel;
import org.josh.climber.service.SessionService;
import org.josh.climber.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final SessionService sessionService;
    private final UserService userService;

    public SessionController(SessionService sessionService, UserService userService) {
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @GetMapping
    public List<SessionDTO> getAllSessions(){
        return sessionService.getAllSessions();
    }

    @GetMapping("/{sessionId}")
    public SessionDTO findBySessionId(@PathVariable Long sessionId){
        return sessionService.findBySessionId(sessionId);
    }

    @PostMapping
    public SessionModel createSession(@RequestBody SessionModel session){
        return sessionService.createSession(session);
    }
}
