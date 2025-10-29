package org.josh.climber.controller;

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

    @GetMapping
    public List<RouteModel> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @PostMapping
    public RouteModel createRoute(@RequestBody RouteModel route){
        return routeService.createRoute(route);
    }
}
