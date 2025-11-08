package org.josh.climber.model.posts;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MediaType media;
    @Column(columnDefinition = "TEXT")
    private String mediaUrl;
    @Column(columnDefinition = "TEXT")
    private String thumbnailUrl;
    @Enumerated(EnumType.STRING)
    private Visibility visibility;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    /* FK */
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
