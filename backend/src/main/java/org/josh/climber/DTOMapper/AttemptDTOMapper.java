package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.attempt.response.AttemptResponseDTO;
import org.josh.climber.model.AttemptModel;
import org.springframework.stereotype.Component;

@Component
public class AttemptDTOMapper {

    public AttemptResponseDTO toDTO(AttemptModel attempt){
        return new AttemptResponseDTO(
                attempt.getAttemptId(),
                attempt.getAttemptTime(),
                attempt.getNotes(),
                attempt.getResult()
        );
    }

    public AttemptModel toEntity(AttemptResponseDTO dto){
        return AttemptModel.builder()
                .attemptTime(dto.attemptTime())
                .notes(dto.notes())
                .result(dto.result())
                .build();
    }
}
