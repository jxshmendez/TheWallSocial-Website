package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.UserPreviewDTO;
import org.josh.climber.model.UserModel;

public class UserPreviewDTOMapper {
    public static UserPreviewDTO toDTO(UserModel user){
        if(user == null) return null;

        return new UserPreviewDTO(
                user.getUserId(),
                user.getUsername(),
                user.getAvatarUrl()
        );
    }
}
