package org.josh.climber.DTOMapper.posts;

import org.josh.climber.DTO.posts.PostCommentsDTO;
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
                comment.getPosts().getPostId(),
                comment.getUser().getUserId(),
                comment.getUser().getUsername()
        );
    }
}
