package org.josh.climber.model.posts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.josh.climber.model.SessionModel;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "postLikes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostLikesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postLikeId;
    @CreatedDate
    private LocalDateTime createdAt;

    /*FK*/
    @JsonBackReference("posts-postLikes")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    PostsModel posts;

}
