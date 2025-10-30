package org.josh.climber.service;

import org.josh.climber.DTO.AttemptDTO;
import org.josh.climber.DTOMapper.AttempDTOMapper;
import org.josh.climber.model.AttemptModel;
import org.josh.climber.repository.AttemptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttemptService {

    private final AttemptRepository attemptRepo;
    private final AttempDTOMapper mapper;

    public AttemptService(AttemptRepository attemptRepo, AttempDTOMapper mapper) {
        this.attemptRepo = attemptRepo;
        this.mapper = mapper;
    }

    public AttemptDTO findByAttemptId(Long attemptId){
        AttemptModel attempt = attemptRepo.findByAttemptId(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found: " + attemptId));
        return mapper.toDTO(attempt);
    }

    public List<AttemptDTO> getAllAttempts(){
        return attemptRepo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public AttemptModel createAttempt(AttemptModel attempt){
        return attemptRepo.save(attempt);
    }
}
