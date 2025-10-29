package org.josh.climber.service;

import org.josh.climber.model.AttemptModel;
import org.josh.climber.repository.AttemptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttemptService {

    private final AttemptRepository attemptRepo;

    public AttemptService(AttemptRepository attemptRepo) {
        this.attemptRepo = attemptRepo;
    }

    public List<AttemptModel> getAllAttempts(){
        return attemptRepo.findAll();
    }

    public AttemptModel createAttempt(AttemptModel attempt){
        return attemptRepo.save(attempt);
    }
}
