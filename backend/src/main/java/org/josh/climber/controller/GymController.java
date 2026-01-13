package org.josh.climber.controller;

import jakarta.validation.Valid;
import org.josh.climber.DTO.gym.response.GymDetailDTO;
import org.josh.climber.DTO.route.response.RouteDTO;
import org.josh.climber.service.GymService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gyms")
public class GymController {

    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping("/{gymId}")
    public GymDetailDTO findByGymId(@PathVariable Long gymId){
        return gymService.findByGymId(gymId);
    }

    @GetMapping
    public List<GymDetailDTO> getAllGyms(){
        return gymService.getAllGyms();
    }

    @GetMapping("/{gymId}/routes")
    public List<RouteDTO> getRoutesByGym(@PathVariable Long gymId){
        return gymService.getRoutesByGymId(gymId);
    }

    @PostMapping
    public GymDetailDTO createGym(@Valid @RequestBody GymDetailDTO gym){
        return gymService.createGym(gym);
    }

    @PutMapping("/{gymId}")
    public GymDetailDTO updateGym(@PathVariable Long gymId, @Valid @RequestBody GymDetailDTO gym){
        return gymService.updateGym(gymId, gym);
    }

    @DeleteMapping("/{gymId}")
    public void deleteGym(@PathVariable Long gymId){
        gymService.deleteGym(gymId);
    }
}
