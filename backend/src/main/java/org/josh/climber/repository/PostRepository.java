package org.josh.climber.repository;

import org.josh.climber.model.UserModel;
import org.josh.climber.model.posts.PostsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<PostsModel, Long> {
    List<PostsModel> findAllByOrderByCreatedAtDesc();
    List<PostsModel> findAllByUserOrderByCreatedAtDesc(UserModel user);

}
