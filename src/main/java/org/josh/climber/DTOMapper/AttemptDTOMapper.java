package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.AttemptDTO;
import org.josh.climber.model.AttemptModel;
import org.springframework.stereotype.Component;

@Component
public class AttemptDTOMapper {

    public AttemptDTO toDTO(AttemptModel attempt){
        return new AttemptDTO(
                attempt.getAttemptId(),
                attempt.getAttemptTime(),
                attempt.getNotes(),
                attempt.getResult()
        );
    }

    public AttemptModel toEntity(AttemptDTO dto){
        return AttemptModel.builder()
                .attemptTime(dto.attemptTime())
                .notes(dto.notes())
                .result(dto.result())
                .build();
    }
}
