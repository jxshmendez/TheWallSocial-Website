package org.josh.climber.controller;

import org.josh.climber.model.AttemptModel;
import org.josh.climber.repository.AttemptRepository;
import org.josh.climber.service.AttemptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attempts")
public class AttemptController {

    private final AttemptService attemptService;

    public AttemptController(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @GetMapping
    public List<AttemptModel> getAllAttempts(){
        return attemptService.getAllAttempts();
    }

    @PostMapping
    public AttemptModel createAttempt(@RequestBody AttemptModel attempt){
        return attemptService.createAttempt(attempt);
    }
}
