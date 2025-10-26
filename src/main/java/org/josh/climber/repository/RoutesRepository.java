package org.josh.climber.repository;

import org.josh.climber.model.RoutesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutesRepository extends JpaRepository<RoutesModel, Long> {
    RoutesModel findByRouteId(Long routeId);
}
