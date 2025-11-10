package org.josh.climber.model.posts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.josh.climber.model.UserModel;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCommentsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postCommentsId;
    @Column(columnDefinition = "TEXT")
    private String postCommentText;
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(nullable = false)
    @Builder.Default
    private boolean deleted = false;


    @JsonBackReference("posts-postComments")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    PostsModel posts;

    @JsonBackReference("user-postComments")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserModel user;


}
