package org.josh.climber.repository;

import org.josh.climber.model.RouteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<RouteModel, Long> {
    Optional<RouteModel> findByRouteId(Long routeId);
}
