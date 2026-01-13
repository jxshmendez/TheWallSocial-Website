package org.josh.climber.controller;

import jakarta.validation.Valid;
import org.josh.climber.DTO.attempt.response.AttemptResponseDTO;
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
    public AttemptResponseDTO findByAttemptId(@PathVariable Long attemptId){
        return attemptService.findByAttemptId(attemptId);
    }

    @GetMapping
    public List<AttemptResponseDTO> getAllAttempts(){
        return attemptService.getAllAttempts();
    }

    @PostMapping
    public AttemptResponseDTO createAttempt(@Valid @RequestBody AttemptResponseDTO attempt){
        return attemptService.createAttempt(attempt);
    }

    @PutMapping("/{attemptId}")
    public AttemptResponseDTO updateAttempt(@PathVariable Long attemptId, @Valid @RequestBody AttemptResponseDTO attempt){
        return attemptService.updateAttempt(attemptId, attempt);
    }

    @DeleteMapping("/{attemptId}")
    public void deleteAttempt(@PathVariable Long attemptId){
        attemptService.deleteAttempt(attemptId);
    }
}
