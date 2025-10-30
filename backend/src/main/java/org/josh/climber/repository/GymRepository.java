package org.josh.climber.repository;

import org.josh.climber.model.GymModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GymRepository extends JpaRepository<GymModel, Long> {
    Optional<GymModel> findByGymId(Long gymId);
}
