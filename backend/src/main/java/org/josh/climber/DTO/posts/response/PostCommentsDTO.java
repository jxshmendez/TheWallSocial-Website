package org.josh.climber.DTO.posts.response;

import java.time.LocalDateTime;

public record PostCommentsDTO(
        Long postCommentsId,
        String postCommentText,
        LocalDateTime createdAt,
        Long postId,
        Long userId,
        String username
) {}
