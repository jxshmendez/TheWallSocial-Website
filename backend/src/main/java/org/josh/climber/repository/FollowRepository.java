package org.josh.climber.repository;

import org.josh.climber.model.FollowModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<FollowModel, Integer> {

    boolean existsByFollower_UserIdAndFollowing_UserId(Long followerId, Long followingId);
}
