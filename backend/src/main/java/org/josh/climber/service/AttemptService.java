package org.josh.climber.service;

import jakarta.validation.Valid;
import org.josh.climber.DTO.attempt.response.AttemptResponseDTO;
import org.josh.climber.DTOMapper.AttemptDTOMapper;
import org.josh.climber.model.AttemptModel;
import org.josh.climber.repository.AttemptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles all operations related to Attempts
 */
@Service
public class AttemptService {

    private final AttemptRepository attemptRepo;
    private final AttemptDTOMapper mapper;

    public AttemptService(AttemptRepository attemptRepo, AttemptDTOMapper mapper) {
        this.attemptRepo = attemptRepo;
        this.mapper = mapper;
    }

    public AttemptResponseDTO findByAttemptId(Long attemptId){
        AttemptModel attempt = attemptRepo.findByAttemptId(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found: " + attemptId));
        return mapper.toDTO(attempt);
    }

    public List<AttemptResponseDTO> getAllAttempts(){
        return attemptRepo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public AttemptResponseDTO createAttempt(AttemptResponseDTO dto){
        AttemptModel attempt = mapper.toEntity(dto);
        AttemptModel saved = attemptRepo.save(attempt);
        return mapper.toDTO(saved);
    }

    public AttemptResponseDTO updateAttempt(Long attemptId, @Valid AttemptResponseDTO attempt) {
        AttemptModel existing = attemptRepo.findByAttemptId(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found: " + attemptId));

        existing.setAttemptTime(attempt.attemptTime());
        existing.setNotes(attempt.notes());
        existing.setResult(attempt.result());

        AttemptModel updated = attemptRepo.save(existing);
        return mapper.toDTO(updated);
    }

    public void deleteAttempt(Long attemptId) {
        if(!attemptRepo.existsById(attemptId)){
            throw new RuntimeException("Attempt not found");
        }
    }
}

