package org.josh.climber.controller;

import org.josh.climber.model.UserModel;
import org.josh.climber.repository.UserRepository;
import org.josh.climber.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }
}
