package org.josh.climber.controller;

import jakarta.validation.Valid;
import org.josh.climber.DTO.AttemptDTO;
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
    public AttemptDTO createAttempt(@Valid @RequestBody AttemptDTO attempt){
        return attemptService.createAttempt(attempt);
    }

    @PutMapping("/{attemptId}")
    public AttemptDTO updateAttempt(@PathVariable Long attemptId, @Valid @RequestBody AttemptDTO attempt){
        return attemptService.updateAttempt(attemptId, attempt);
    }

    @DeleteMapping("/{attemptId}")
    public void deleteAttempt(@PathVariable Long attemptId){
        attemptService.deleteAttempt(attemptId);
    }
}
