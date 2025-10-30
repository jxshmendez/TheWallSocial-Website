package org.josh.climber.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attempts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttemptModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attemptId;
    private int attemptTime;
    @Column(columnDefinition = "TEXT")
    private String notes;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResultType result;

    /* FK */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-attempt")
    private UserModel user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "session_id")
    @JsonBackReference("attempt-session")
    private SessionModel session;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    @JsonBackReference("route-attempt")
    private RouteModel routes;



}
