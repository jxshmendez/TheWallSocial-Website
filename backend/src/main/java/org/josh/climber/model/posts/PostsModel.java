package org.josh.climber.model.posts;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.josh.climber.model.RouteModel;
import org.josh.climber.model.SessionModel;
import org.josh.climber.model.UserModel;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
        name = "posts",
        indexes = {
                @Index(columnList = "user_id"),
                @Index(columnList = "createdAt")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(columnDefinition = "TEXT")
    private String caption;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private Visibility visibility = Visibility.PUBLIC;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    /* FK */
    @Builder.Default
    @OneToMany(mappedBy = "posts", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PostCommentsModel> postComments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("post-media")
    private List<MediaModel> mediaList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "posts", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PostLikesModel> postLikes = new ArrayList<>();

    @JsonBackReference("session-posts")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private SessionModel session;

    @JsonBackReference("route-posts")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private RouteModel routes;

    @JsonBackReference("user-posts")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;
}
