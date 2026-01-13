package org.josh.climber.controller;

import jakarta.validation.Valid;
import org.josh.climber.DTO.session.response.SessionDTO;
import org.josh.climber.DTO.user.response.UserDTO;
import org.josh.climber.DTO.user.response.UserPreviewDTO;
import org.josh.climber.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public List<UserPreviewDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    // private user
    @GetMapping("/me")
    public UserDTO getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return userService.findByUsername(user.getUsername());
    }

    @GetMapping("/id/{userId}")
    public UserPreviewDTO findByUserId(@PathVariable Long userId){
        return userService.getPreviewById(userId);
    }

    @GetMapping("/username/{username}")
    public UserPreviewDTO findByUsername(@PathVariable String username ){
        return userService.getPreviewByUsername(username);
    }

    @GetMapping("/username/{username}/sessions")
    public List<SessionDTO> getSessionByUser(@PathVariable String username){
        return userService.getSessionByUser(username);
    }

    @PutMapping("/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO user){
        return userService.updateUser(userId, user);
    }

    @PatchMapping("/bio")
    public UserPreviewDTO updateBio(@RequestBody String bio) {

        Long userId = (Long) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        return userService.updateBio(userId, bio);
    }

    @PatchMapping("/avatar")
    public UserPreviewDTO updateAvatar(@RequestBody String avatarUrl){
        Long userId = (Long) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        return userService.updateAvatar(userId, avatarUrl);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
