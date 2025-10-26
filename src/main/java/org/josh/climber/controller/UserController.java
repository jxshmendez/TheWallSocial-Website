package org.josh.climber.controller;

import org.josh.climber.model.UserModel;
import org.josh.climber.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public List<UserModel> getAllUsers(){
        return repo.findAll();
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){
        return repo.save(user);
    }
}
