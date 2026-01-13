package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.gym.response.GymDetailDTO;
import org.josh.climber.model.GymModel;
import org.springframework.stereotype.Component;

@Component
public class GymDTOMapper {

    public GymDetailDTO toDTO(GymModel gym){
        return new GymDetailDTO(
                gym.getGymId(),
                gym.getName(),
                gym.getLocation()
        );
    }

    public GymModel toEntity(GymDetailDTO dto){
        return GymModel.builder()
                .name(dto.name())
                .location(dto.location())
                .build();
    }
}
