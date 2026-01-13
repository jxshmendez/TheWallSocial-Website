package org.josh.climber.DTOMapper;

import org.josh.climber.DTO.follow.response.FollowDTO;
import org.josh.climber.model.FollowModel;
import org.springframework.stereotype.Component;

@Component
public class FollowDTOMapper {
    public FollowDTO toDTO(FollowModel follow) {
        if (follow == null) return null;
        
        return new FollowDTO(
                follow.getFollowId(),
                follow.getFollower() != null ? follow.getFollower().getUserId() : null,
                follow.getFollower() != null ? follow.getFollower().getUsername() : null,
                follow.getFollowing() != null ? follow.getFollowing().getUserId() : null,
                follow.getFollowing() != null ? follow.getFollowing().getUsername() : null,
                follow.getCreatedAt()
        );
    }
}

