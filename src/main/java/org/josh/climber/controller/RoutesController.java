package org.josh.climber.controller;

import org.josh.climber.model.RoutesModel;
import org.josh.climber.repository.RoutesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RoutesController {

    private final RoutesRepository repo;

    public RoutesController(RoutesRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<RoutesModel> getAllRoutes(){
        return repo.findAll();
    }

    @PostMapping
    public RoutesModel createRoute(@RequestBody RoutesModel route){
        return repo.save(route);
    }
}
