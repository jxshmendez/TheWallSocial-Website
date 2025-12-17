package org.josh.climber.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.josh.climber.model.posts.PostsModel;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "session")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sessionId;
    private LocalDateTime sessionDate;
    private int durationMinutes;
    @Column(columnDefinition = "TEXT")
    private String notes;
    private LocalDateTime createdAt;

    /* FK */
    @Builder.Default
    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("session-posts")
    private List<PostsModel> post = new ArrayList<>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-session")
    private UserModel user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gym_id")
    @JsonBackReference("gym-session")
    private GymModel gym;

    @Builder.Default
    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
    @JsonManagedReference("attempt-session")
    private List<AttemptModel> attempts = new ArrayList<>();




}
