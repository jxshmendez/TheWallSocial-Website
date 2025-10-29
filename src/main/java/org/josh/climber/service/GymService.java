package org.josh.climber.service;

import org.josh.climber.model.GymModel;
import org.josh.climber.repository.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {

    private final GymRepository gymRepo;

    public GymService(GymRepository gymRepo) {
        this.gymRepo = gymRepo;
    }

    public List<GymModel> getAllGyms(){
        return gymRepo.findAll();
    }

    public GymModel createGym(GymModel gym){
        return gymRepo.save(gym);
    }
}
