package org.josh.climber.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "gym",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "latitude", "longitude"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GymModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gymId;

    private String name;
    private String location;
    private Double latitude;
    private Double longitude;

    @Builder.Default
    @OneToMany(mappedBy = "gym", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("gym-session")
    private List<SessionModel> sessions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "gym", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RouteModel> routes = new ArrayList<>();

}
