package org.josh.climber.service;

import org.josh.climber.model.RouteModel;
import org.josh.climber.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepo;

    public RouteService(RouteRepository routeRepo) {
        this.routeRepo = routeRepo;
    }

    public List<RouteModel> getAllRoutes(){
        return routeRepo.findAll();
    }

    public RouteModel createRoute(RouteModel route){
        return routeRepo.save(route);
    }
}
