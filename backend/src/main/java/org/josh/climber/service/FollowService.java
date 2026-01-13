package org.josh.climber.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.josh.climber.DTO.follow.response.FollowDTO;
import org.josh.climber.DTOMapper.FollowDTOMapper;
import org.josh.climber.model.FollowModel;
import org.josh.climber.model.UserModel;
import org.josh.climber.repository.FollowRepository;
import org.josh.climber.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FollowService {

    private final FollowRepository repo;
    private final UserRepository userRepo;
    private final FollowDTOMapper followDTOMapper;

    public FollowService(FollowRepository repo, UserRepository userRepo, FollowDTOMapper followDTOMapper) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.followDTOMapper = followDTOMapper;
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

    @Transactional
    public void unfollowUser(Long followerId, Long followingId){
        if (followerId == followingId){
            throw new RuntimeException("You cannot unfollow yourself");
        }

        if(!repo.existsByFollower_UserIdAndFollowing_UserId(followerId, followingId)){
            throw new RuntimeException("Following does not exist");
        }

        FollowModel follow = repo
                .findByFollower_UserIdAndFollowing_UserId(followerId, followingId)
                .orElseThrow(() -> new RuntimeException("Follow relationship does not exist"));

        repo.delete(follow);
    }

    public List<FollowDTO> getFollowing(Long userId){
        userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<FollowModel> follows = repo
                .findByFollower_UserId(userId);

        return follows.stream()
                .map(followDTOMapper::toDTO)
                .toList();
    }

    public List<FollowDTO> getFollowers(Long userId){
        userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<FollowModel> followers = repo
                .findByFollowing_UserId(userId);

        return followers.stream()
                .map(followDTOMapper::toDTO)
                .toList();
    }
}
