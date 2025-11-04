package org.josh.climber.DTO;

public record AuthRequestDTO(
        String username,
        String email,
        String password
) {
}
