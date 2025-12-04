package org.josh.climber.controller;

import org.josh.climber.DTO.FollowDTO;
import org.josh.climber.model.UserModel;
import org.josh.climber.repository.UserRepository;
import org.josh.climber.service.FollowService;
import org.josh.climber.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    private final FollowService service;
    private final UserRepository userRepo;

    public FollowController(FollowService service, UserRepository userRepo) {
        this.service = service;
        this.userRepo = userRepo;
    }

    @PostMapping("/users/{targetUserId}/follow")
    public ResponseEntity<String> followUser(@PathVariable Long targetUserId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        UserModel follower  = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Long followerId = follower.getUserId();

        service.followUser(followerId, targetUserId);
        return ResponseEntity.ok("Followed successfully");
    }

    @DeleteMapping("/users/{targetUserId}/follow")
    public ResponseEntity<?> unfollow(@PathVariable Long targetUserId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        UserModel follower = userRepo.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        Long followerId = follower.getUserId();

        service.unfollowUser(followerId, targetUserId);

        return ResponseEntity.ok("Unfollowed successfully");
    }

    @GetMapping("/users/{userId}/followers")
    public ResponseEntity<List<FollowDTO>> getFollowers(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getFollowers(userId));
    }

    @GetMapping("/users/{userId}/following")
    public ResponseEntity<List<FollowDTO>> getFollowing(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getFollowing(userId));
    }

}
