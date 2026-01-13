package org.josh.climber.DTOMapper.posts;

import org.josh.climber.DTO.posts.response.PostCommentsDTO;
import org.josh.climber.model.posts.PostCommentsModel;
import org.springframework.stereotype.Component;

@Component
public class PostCommentsDTOMapper {

    public PostCommentsDTO toDTO(PostCommentsModel comment) {
        if (comment == null) return null;

        return new PostCommentsDTO(
                comment.getPostCommentsId(),
                comment.getPostCommentText(),
                comment.getCreatedAt(),
                comment.getPosts() != null ? comment.getPosts().getPostId() : null,
                comment.getUser() != null ? comment.getUser().getUserId() : null,
                comment.getUser() != null ? comment.getUser().getUsername() : null
        );
    }
}
