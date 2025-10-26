package org.josh.climber.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "routes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoutesModel {
    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long routeId;
    private String name;
    private String grade;
    private String style;
    private String setter;
    private LocalDateTime createdAt;

    /* FK */
    @OneToMany(mappedBy = "routes", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AttemptsModel> attempts;

    // Validation Methods
    private boolean isOutdoor;
    @AssertTrue(message="Only outdoor routes can have names")
    private boolean isValidNameCondition() {
        return (isOutdoor && name != null && !name.isBlank())
                || (!isOutdoor && (name == null || name.isBlank()));
    }

    /* TODO
    Add gymId FK
     */
}
