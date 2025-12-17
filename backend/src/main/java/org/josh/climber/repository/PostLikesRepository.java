package org.josh.climber.repository;

import org.josh.climber.model.UserModel;
import org.josh.climber.model.posts.PostLikesModel;
import org.josh.climber.model.posts.PostsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikesRepository extends JpaRepository<PostLikesModel, Long> {
    boolean existsByPostsAndUser(PostsModel post, UserModel user);
    void deleteByPostsAndUser(PostsModel post, UserModel user);
}
