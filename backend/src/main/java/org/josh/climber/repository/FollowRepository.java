package org.josh.climber.repository;

import org.josh.climber.model.FollowModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<FollowModel, Long> {

    boolean existsByFollower_UserIdAndFollowing_UserId(Long followerId, Long followingId);
    Optional<FollowModel> findByFollower_UserIdAndFollowing_UserId(Long followerId, Long followingId);

    List<FollowModel> findByFollower_UserId(Long followerId);

    List<FollowModel> findByFollowing_UserId(Long followingId);
}
