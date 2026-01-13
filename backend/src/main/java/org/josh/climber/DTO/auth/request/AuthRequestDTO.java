package org.josh.climber.DTO.auth.request;

public record AuthRequestDTO(
        String username,
        String email,
        String password
) {
}
