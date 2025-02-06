package com.migia.controller;

import com.migia.model.*;
import com.migia.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private ChatService chatService;

    // User Endpoints
    @PostMapping("/users/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/users/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // Post Endpoints
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("/posts/user/{username}")
    public List<Post> getPostsByUser(@PathVariable String username) {
        return postService.getPostsByUser(username);
    }

    // Comment Endpoints
    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @GetMapping("/comments/post/{postId}")
    public List<Comment> getCommentsByPost(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }

    // Like Endpoints
    @PostMapping("/likes")
    public Like addLike(@RequestBody Like like) {
        return likeService.addLike(like);
    }

    @GetMapping("/likes/post/{postId}/count")
    public Long getLikeCountByPost(@PathVariable Long postId) {
        return likeService.getLikeCountByPost(postId);
    }

    // Chat Endpoints
    @PostMapping("/chats")
    public Chat sendMessage(@RequestBody Chat chat) {
        return chatService.sendMessage(chat);
    }

    @GetMapping("/chats/{senderUsername}/{receiverUsername}")
    public List<Chat> getChatBetweenUsers(
            @PathVariable String senderUsername,
            @PathVariable String receiverUsername) {
        return chatService.getChatBetweenUsers(senderUsername, receiverUsername);
    }
}