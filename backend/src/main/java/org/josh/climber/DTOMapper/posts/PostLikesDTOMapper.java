package org.josh.climber.DTOMapper.posts;

import org.josh.climber.DTO.posts.response.PostLikesDTO;
import org.josh.climber.model.posts.PostLikesModel;
import org.springframework.stereotype.Component;

@Component
public class PostLikesDTOMapper {

    public PostLikesDTO toDTO(PostLikesModel like){
        if (like == null) return null;

        return new PostLikesDTO(
                like.getUser().getUserId(),
                like.getUser().getUsername()

        );
    }
}
