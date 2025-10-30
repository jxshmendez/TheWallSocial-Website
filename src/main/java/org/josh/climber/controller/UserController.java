package org.josh.climber.controller;

import jakarta.validation.Valid;
import org.josh.climber.DTO.SessionDTO;
import org.josh.climber.DTO.UserDTO;
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
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public UserDTO findByUsername(@PathVariable String username ){
        return userService.findByUsername(username);
    }

    @GetMapping("/{username}/sessions")
    public List<SessionDTO> getSessionByUser(@PathVariable String username){
        return userService.getSessionByUser(username);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO user){
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO user){
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
