package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.route.response.RouteDTO;
import org.josh.climber.model.RouteModel;
import org.springframework.stereotype.Component;

@Component
public class RouteDTOMapper {

    public RouteDTO toDTO(RouteModel route){
        return new RouteDTO(
                route.getRouteId(),
                route.getName(),
                route.getIsOutdoor(),
                route.getGrade(),
                route.getStyle(),
                route.getSetter(),
                route.getCreatedAt()
        );
    }

    public RouteModel toEntity(RouteDTO dto) {
        return RouteModel.builder()
                .name(dto.name())
                .isOutdoor(dto.isOutdoor())
                .grade(dto.grade())
                .style(dto.style())
                .setter(dto.setter())
                .build();
    }
}
