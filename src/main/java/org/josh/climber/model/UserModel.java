package org.josh.climber.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String email;
    private String avatarUrl;
    @Column(columnDefinition = "TEXT")
    private String bio;
    private LocalDateTime createdAt;

    /* FK */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SessionModel> sessions;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AttemptsModel> attempts;



    /* TODO */
    // Implement this:
    //@Column(nullable = false)
    //private String passwordHash;
}
