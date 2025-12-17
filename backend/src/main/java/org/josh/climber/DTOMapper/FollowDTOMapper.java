package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.FollowDTO;
import org.josh.climber.model.FollowModel;

public class FollowDTOMapper {
    public static FollowDTO toDTO(FollowModel follow) {
        return new FollowDTO(
                follow.getFollowId(),
                follow.getFollower().getUserId(),
                follow.getFollower().getUsername(),
                follow.getFollowing().getUserId(),
                follow.getFollowing().getUsername(),
                follow.getCreatedAt()
        );
    }
}

