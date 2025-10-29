package org.josh.climber.repository;

import org.josh.climber.model.GymModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<GymModel, Long> {
    GymModel findByGymId(Long gymId);
}
