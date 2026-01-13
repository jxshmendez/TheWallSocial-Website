package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.user.response.UserDTO;
import org.josh.climber.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {

    public UserDTO toDTO(UserModel user){
        return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getAvatarUrl(),
                user.getBio(),
                user.getCreatedAt()
        );
    }

    public UserModel toEntity(UserDTO dto){
        return UserModel.builder()
                .username(dto.username())
                .email(dto.email())
                .avatarUrl(dto.avatarUrl())
                .bio(dto.bio())
                .build();
    }
}
