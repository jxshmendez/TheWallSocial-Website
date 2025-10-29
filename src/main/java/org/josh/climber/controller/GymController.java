package org.josh.climber.controller;

import org.josh.climber.model.GymModel;
import org.josh.climber.service.GymService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GymController {

    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping
    public List<GymModel> getAllGyms(){
        return gymService.getAllGyms();
    }

    @PostMapping
    public GymModel createGym(GymModel gym){
        return gymService.createGym(gym);
    }

}
