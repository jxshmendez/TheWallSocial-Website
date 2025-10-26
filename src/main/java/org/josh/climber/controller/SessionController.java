package org.josh.climber.controller;

import org.josh.climber.model.SessionModel;
import org.josh.climber.repository.SessionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final SessionRepository repo;

    public SessionController(SessionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<SessionModel> getAllSessions(){
        return repo.findAll();
    }

    @PostMapping
    public SessionModel createSession(@RequestBody SessionModel session){
        return repo.save(session);
    }
}
