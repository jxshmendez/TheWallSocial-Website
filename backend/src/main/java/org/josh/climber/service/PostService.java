package org.josh.climber.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.josh.climber.DTO.posts.CreatePostDTO;
import org.josh.climber.DTO.posts.PostDTO;
import org.josh.climber.DTOMapper.posts.PostDTOMapper;
import org.josh.climber.model.UserModel;
import org.josh.climber.model.posts.PostLikesModel;
import org.josh.climber.model.posts.PostsModel;
import org.josh.climber.repository.PostLikesRepository;
import org.josh.climber.repository.PostRepository;
import org.josh.climber.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostLikesRepository postLikesRepository;
    private final PostDTOMapper postDTOMapper;

    /**
     * Get all post for the public feed
     */
    public List<PostDTO> getAllPosts(){
        return postRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(postDTOMapper::toDTO)
                .toList();
    }

    /**
     * Get all posts by specific user
     */
    public List<PostDTO> getPostsByUser(Long userId){
        UserModel user  = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return postRepository.findAllByUserOrderByCreatedAtDesc(user)
                .stream()
                .map(postDTOMapper::toDTO)
                .toList();
    }

    /**
     * Get single post by ID
     */
    public PostDTO getPostById(Long postId){
        PostsModel post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        return postDTOMapper.toDTO(post);
    }

    /**
     * Create a new post
     */
    public PostDTO createPost(CreatePostDTO dto, String username) {
        UserModel user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        PostsModel post = PostsModel.builder()
                .caption(dto.caption())
                .visibility(dto.visibility())
                .user(user)
                .build();

        PostsModel saved = postRepository.save(post);
        return postDTOMapper.toDTO(saved);
    }

    /**
     * Delete a post by ID
     */
    public void deletePost(Long postId, String username){
        PostsModel post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        UserModel user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!Objects.equals(post.getUser().getUserId(), user.getUserId())) {
            throw new SecurityException("Not authorised to delete this post");
        }

        postRepository.delete(post);
    }

    /**
     * Like or unlike a post
     */
    public PostDTO toggleLike(Long postId, String username) {
        UserModel user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        PostsModel post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        boolean alreadyLiked = postLikesRepository.existsByPostsAndUser(post, user);

        if (alreadyLiked) {
            postLikesRepository.deleteByPostsAndUser(post, user);
        } else {
            PostLikesModel like = PostLikesModel.builder()
                    .posts(post)
                    .user(user)
                    .createdAt(LocalDateTime.now())
                    .build();
            postLikesRepository.save(like);
        }

        PostsModel refreshed = postRepository.findById(post.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        return postDTOMapper.toDTO(refreshed);
    }

}
