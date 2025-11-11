package org.josh.climber.service;

import jakarta.transaction.Transactional;
import org.josh.climber.model.FollowModel;
import org.josh.climber.model.UserModel;
import org.josh.climber.repository.FollowRepository;
import org.josh.climber.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    private final FollowRepository repo;
    private final UserRepository userRepo;

    public FollowService(FollowRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @Transactional
    public void followUser(Long followerId, Long followingId) {
        if(followerId.equals(followingId)){
            throw new RuntimeException("You cannot follow yourself");
        }

        if(repo.existsByFollower_UserIdAndFollowing_UserId(followerId, followingId)){
            throw new RuntimeException("Already following this user");
        }

        UserModel follower = userRepo.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));
        UserModel following = userRepo.findById(followingId)
                .orElseThrow(() -> new RuntimeException("User to follow not found"));

        FollowModel follow = FollowModel.builder()
                .follower(follower)
                .following(following)
                .build();

        repo.save(follow);
    }
}
