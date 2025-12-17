package org.josh.climber.DTOMapper.posts;

import org.josh.climber.DTO.posts.PostDTO;
import org.josh.climber.model.posts.PostsModel;
import org.springframework.stereotype.Component;

@Component
public class PostDTOMapper {

    public PostDTO toDTO(PostsModel post) {
        if (post == null) return null;

        return new PostDTO(
                post.getPostId(),
                post.getCaption(),
                post.getVisibility(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getUser() != null ? post.getUser().getUserId() : null,
                post.getUser() != null ? post.getUser().getUsername() : null,
                post.getRoutes() != null ? post.getRoutes().getRouteId() : null,
                post.getRoutes() != null ? post.getRoutes().getName() : null,
                post.getSession() != null ? post.getSession().getSessionId() : null
        );
    }
}
