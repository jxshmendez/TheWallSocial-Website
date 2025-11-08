package org.josh.climber.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.josh.climber.model.posts.PostsModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteModel {
    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private String name;
    private String grade;
    private String style;
    private String setter;
    private LocalDateTime createdAt;

    /* FK */
    @Builder.Default
    @OneToMany(mappedBy = "routes", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("route-posts")
    private List<PostsModel> posts = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "routes", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("route-attempt")
    private List<AttemptModel> attempts = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gym_id")
    @JsonIgnoreProperties({"location", "latitude", "longitude"})
    private GymModel gym;

    // Validation Methods
    private Boolean isOutdoor;
    @AssertTrue(message="Only outdoor routes can have names")
    private boolean isValidNameCondition() {
        return (isOutdoor && name != null && !name.isBlank())
                || (!isOutdoor && (name == null || name.isBlank()));
    }



}
