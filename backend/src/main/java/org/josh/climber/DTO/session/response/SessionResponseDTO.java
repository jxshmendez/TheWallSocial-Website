package org.josh.climber.DTO.session.response;

import org.josh.climber.DTO.gym.response.GymResponseDTO;
import org.josh.climber.DTO.user.response.UserPreviewDTO;

import java.time.LocalDateTime;

public record SessionResponseDTO(
        Long sessionId,
        LocalDateTime sessionDate,
        Integer durationMinutes,
        String notes,
        LocalDateTime createdAt,

        UserPreviewDTO user,
        GymResponseDTO gym,

        Integer attemptCount,
        Integer postCount

) {
}
