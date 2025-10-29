package org.josh.climber.controller;

import org.josh.climber.model.SessionModel;
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
    public List<SessionModel> getAllSessions(){
        return sessionService.getAllSessions();
    }

    @PostMapping
    public SessionModel createSession(@RequestBody SessionModel session){
        return sessionService.createSession(session);
    }
}
