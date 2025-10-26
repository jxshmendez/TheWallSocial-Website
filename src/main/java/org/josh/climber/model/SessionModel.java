package org.josh.climber.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
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

    /* FK */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"sessions", "bio", "createdAt"})
    private UserModel user;

    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AttemptsModel> attempts;

    private LocalDateTime sessionDate;
    private int durationMinutes;
    @Column(columnDefinition = "TEXT")
    private String notes;
    private LocalDateTime createdAt;

    /* TODO */
    // Add gym id later
}
