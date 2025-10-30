package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.GymDTO;
import org.josh.climber.model.GymModel;
import org.springframework.stereotype.Component;

@Component
public class GymDTOMapper {

    public GymDTO toDTO(GymModel gym){
        return new GymDTO(
                gym.getGymId(),
                gym.getName(),
                gym.getLocation()
        );
    }

    public GymModel toEntity(GymDTO dto){
        return GymModel.builder()
                .name(dto.name())
                .location(dto.location())
                .build();
    }
}
