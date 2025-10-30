package org.josh.climber.controller;

import jakarta.validation.Valid;
import org.josh.climber.DTO.RouteDTO;
import org.josh.climber.model.RouteModel;
import org.josh.climber.repository.RouteRepository;
import org.josh.climber.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/{routeId}")
    public RouteDTO findByRouteId(@PathVariable Long routeId){
        return routeService.findByRouteId(routeId);
    }

    @GetMapping
    public List<RouteDTO> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @PostMapping
    public RouteDTO createRoute(@Valid @RequestBody RouteDTO route){
        return routeService.createRoute(route);
    }

    @PutMapping("/{routeId}")
    public RouteDTO updateRoute(@PathVariable Long routeId, @Valid @RequestBody RouteDTO route){
        return routeService.updateRoute(routeId, route);
    }

    @DeleteMapping("/{routeId}")
    public void deleteRoute(@PathVariable Long routeId){
        routeService.deleteRoute(routeId);
    }
}
