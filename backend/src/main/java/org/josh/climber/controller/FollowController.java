package org.josh.climber.controller;

import org.josh.climber.DTO.FollowDTO;
import org.josh.climber.service.FollowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow/")
public class FollowController {

    private final FollowService service;

    public FollowController(FollowService service) {
        this.service = service;
    }

    @PostMapping("/follow")
    public ResponseEntity<String> followUser(@RequestParam Long followerId, @RequestParam Long followingId) {
        service.followUser(followerId, followingId);
        return ResponseEntity.ok("User " + followerId + " followed user " + followingId);
    }

    /*TODO
    * unfollow
    * getFollowers
    * getFollowing
    * */

}
