package org.josh.climber.controller;

import jakarta.validation.Valid;
import org.josh.climber.DTO.AttemptDTO;
import org.josh.climber.model.AttemptModel;
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

    @GetMapping("/{attemptId}")
    public AttemptDTO findByAttemptId(@PathVariable Long attemptId){
        return attemptService.findByAttemptId(attemptId);
    }

    @GetMapping
    public List<AttemptDTO> getAllAttempts(){
        return attemptService.getAllAttempts();
    }

    @PostMapping
    public AttemptModel createAttempt(@Valid @RequestBody AttemptModel attempt){
        return attemptService.createAttempt(attempt);
    }
}
