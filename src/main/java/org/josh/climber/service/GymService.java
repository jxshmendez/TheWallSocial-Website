package org.josh.climber.service;

import jakarta.validation.Valid;
import org.josh.climber.DTO.GymDTO;
import org.josh.climber.DTOMapper.GymDTOMapper;
import org.josh.climber.model.GymModel;
import org.josh.climber.repository.GymRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class GymService {

    private final GymRepository gymRepo;
    private final GymDTOMapper mapper;

    public GymService(GymRepository gymRepo, GymDTOMapper mapper) {
        this.gymRepo = gymRepo;
        this.mapper = mapper;
    }

    public GymDTO findByGymId(Long gymId){
        GymModel gym = gymRepo.findByGymId(gymId)
                .orElseThrow(() -> new RuntimeException("Gym not found: " + gymId));
        return mapper.toDTO(gym);
    }

    public List<GymDTO> getAllGyms(){
        return gymRepo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public GymDTO createGym(GymDTO dto){
        GymModel gym = mapper.toEntity(dto);
        GymModel saved = gymRepo.save(gym);
        return mapper.toDTO(saved);
    }

    public GymDTO updateGym(Long gymId, @Valid GymDTO gym) {
        GymModel exisiting = gymRepo.findByGymId(gymId)
                .orElseThrow(() -> new RuntimeException("Gym not found: " + gymId));

        exisiting.setGymId(gym.gymId());
        exisiting.setName(gym.name());
        exisiting.setLocation(gym.location());

        GymModel updated = gymRepo.save(exisiting);
        return mapper.toDTO(updated);
    }

    public void deleteGym(Long gymId) {
        if(!gymRepo.existsById(gymId)){
            throw new RuntimeException("Gym not found: " + gymId);
        }

        gymRepo.deleteById(gymId);
    }
}
