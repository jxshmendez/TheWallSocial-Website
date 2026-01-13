package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.user.response.UserPreviewDTO;
import org.josh.climber.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserPreviewDTOMapper {
    public UserPreviewDTO toDTO(UserModel user){
        if(user == null) return null;

        return new UserPreviewDTO(
                user.getUserId(),
                user.getUsername(),
                user.getBio(),
                user.getAvatarUrl(),
                user.getFollowing().size(),
                user.getFollowers().size()

        );
    }
}
