package org.josh.climber.repository;

import org.josh.climber.model.RouteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<RouteModel, Long> {
    RouteModel findByRouteId(Long routeId);
}
