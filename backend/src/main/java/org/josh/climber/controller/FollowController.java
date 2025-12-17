package org.josh.climber.controller;

import org.josh.climber.DTO.FollowDTO;
import org.josh.climber.service.FollowService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    private final FollowService service;

    public FollowController(FollowService service) {
        this.service = service;
    }

    @PostMapping("/users/{targetUserId}/follow")
    public ResponseEntity<String> followUser(@PathVariable Long targetUserId) {
        Long followerId = (Long) SecurityContextHolder.getContext()
                        .getAuthentication()
                                .getPrincipal();

        service.followUser(followerId, targetUserId);
        return ResponseEntity.ok("Followed successfully");
    }

    @DeleteMapping("/users/{targetUserId}/follow")
    public ResponseEntity<?> unfollow(@PathVariable Long targetUserId) {
        Long followerId = (Long) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

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
