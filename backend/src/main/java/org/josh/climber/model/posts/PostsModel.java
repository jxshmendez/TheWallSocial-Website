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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
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
    private Visibility visibility;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    /* FK */
    @Builder.Default
    @OneToMany(mappedBy = "posts", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PostLikesModel> postLikes = new ArrayList<>();

    @JsonBackReference("session-posts")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    SessionModel session;

    @JsonBackReference("route-posts")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    RouteModel routes;

    @JsonBackReference("user-posts")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserModel user;
}
