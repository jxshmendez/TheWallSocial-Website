package org.josh.climber.DTO.session.response;

import org.josh.climber.DTO.attempt.response.AttemptResponseDTO;
import org.josh.climber.DTO.gym.response.GymDetailDTO;
import org.josh.climber.DTO.posts.response.PostSummaryDTO;
import org.josh.climber.DTO.user.response.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public record SessionDetailDTO(
        Long sessionId,
        LocalDateTime sessionDate,
        Integer durationMinutes,
        String notes,
        LocalDateTime createAt,

        UserDTO user,
        GymDetailDTO gym,

        List<AttemptResponseDTO> attempts,
        List<PostSummaryDTO> posts
) {
}
