package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.SessionDTO;
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
}
