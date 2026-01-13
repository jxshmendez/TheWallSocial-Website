package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.session.response.SessionDTO;
import org.josh.climber.model.SessionModel;
import org.springframework.stereotype.Component;

@Component
public class SessionDTOMapper {

    public SessionDTO toDTO(SessionModel session){
        return new SessionDTO(
                session.getSessionId(),
                session.getSessionDate(),
                session.getDurationMinutes(),
                session.getNotes(),
                session.getCreatedAt()
        );
    }

    public SessionModel toEntity(SessionDTO dto){
        return SessionModel.builder()
                .sessionDate(dto.sessionDate())
                .durationMinutes(dto.durationMinutes())
                .notes(dto.notes())
                .build();

    }


}
