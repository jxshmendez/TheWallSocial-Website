package org.josh.climber.service;

import jakarta.validation.Valid;
import org.josh.climber.DTO.route.response.RouteDTO;
import org.josh.climber.DTOMapper.RouteDTOMapper;
import org.josh.climber.model.RouteModel;
import org.josh.climber.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles all operations related to Routes
 */
@Service
public class RouteService {

    private final RouteRepository routeRepo;
    private final RouteDTOMapper mapper;

    public RouteService(RouteRepository routeRepo, RouteDTOMapper mapper) {
        this.routeRepo = routeRepo;
        this.mapper = mapper;
    }

    public RouteDTO findByRouteId(Long routeId){
        RouteModel route =  routeRepo.findByRouteId(routeId)
                .orElseThrow(() -> new RuntimeException("Route not found: " + routeId));
        return mapper.toDTO(route);
    }

    public List<RouteDTO> getAllRoutes(){
        return routeRepo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public RouteDTO createRoute(RouteDTO dto){
        RouteModel route = mapper.toEntity(dto);
        RouteModel saved = routeRepo.save(route);
        return mapper.toDTO(saved);
    }

    public RouteDTO updateRoute(Long routeId, @Valid RouteDTO route) {
        RouteModel existing = routeRepo.findById(routeId)
                .orElseThrow(() -> new RuntimeException("Route not found: " + routeId));

        existing.setName(route.name());
        existing.setGrade(route.grade());
        existing.setStyle(route.style());
        existing.setSetter(route.setter());

        RouteModel updated = routeRepo.save(existing);
        return mapper.toDTO(updated);
    }

    public void deleteRoute(Long routeId) {
        if(!routeRepo.existsById(routeId)){
            throw new RuntimeException("Route not found: " + routeId);
        }

        routeRepo.deleteById(routeId);
    }
}
