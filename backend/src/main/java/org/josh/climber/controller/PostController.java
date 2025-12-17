package org.josh.climber.controller.posts;

import lombok.RequiredArgsConstructor;
import org.josh.climber.DTO.posts.PostDTO;
import org.josh.climber.DTO.posts.CreatePostDTO;
import org.josh.climber.model.UserModel;
import org.josh.climber.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    /**
     * Get all posts for the public feed (ordered by createdAt DESC)
     */
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    /**
     * Get posts by a specific user
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Long userId) {
        List<PostDTO> posts = postService.getPostsByUser(userId);
        return ResponseEntity.ok(posts);
    }

    /**
     * Get a single post by ID
     */
    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long postId) {
        PostDTO post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }

    /**
     * Create a new post
     */
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody CreatePostDTO createPostDTO, Principal principal) {
        // principal.getName() = username from JWT
        PostDTO post = postService.createPost(createPostDTO, principal.getName());
        return ResponseEntity.ok(post);
    }

    /**
     * Delete a post by ID (only author or admin can delete)
     */
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId, Principal principal) {
        postService.deletePost(postId, principal.getName());
        return ResponseEntity.noContent().build();
    }

    /**
     * Like or unlike a post
     */
    @PostMapping("/{postId}/like")
    public ResponseEntity<PostDTO> toggleLike(@PathVariable Long postId, Principal principal) {
        PostDTO post = postService.toggleLike(postId, principal.getName());
        return ResponseEntity.ok(post);
    }
}
