package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.service.EmailService;
import org.springframework.web.bind.annotation.*;
import com.example.restblog.service.UserService;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    // TODO: see UsersController for the "why" of this
    private final UserService userService;
    private final EmailService emailService;

    public PostsController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

//    List<Post> posts = new ArrayList<>();

    @GetMapping
    public List<Post> getAll() {
        return userService.getPostList();
//        posts.add(new Post(1L, "Argonne National Laboratory", "A Real-Time Intelligent Speed Optimization Planner Using Reinforcement Learning"));
//        posts.add(new Post(2L, "National Renewable Energy Laboratory", "Shared Automated Vehicle Fleet Operations for First-Mile Last-Mile Transit Connections with Dynamic Pooling"));
//        posts.add(new Post(3L, "Oak Ridge National Laboratory", "Hybrid Neural Network Modeling for Multiple Intersections along Signalized Arterials - Current Situation and Some New Results"));
//        return posts;
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        // TODO: refactor this all out of here
        for (Post post : userService.getPostList()) {
            if (Objects.equals(post.getId(), id)) {
                return post;
            }
        }
        return null;
    }

    @PostMapping
    public void createPost(@RequestBody Post postToAdd) {
        // TODO: If you want to associate the user to the post here, be sure to include a user object property on the post from the client side
        System.out.println(postToAdd);
    }

    @PostMapping("{username}")
    public void createByUsername(@PathVariable String username, @RequestBody Post newPost) {
        // Nice and clean, huh?
        userService.addPost(newPost, username);
    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        // TODO: refactor this ALL out of here to a public method in UserService
        for (Post post : userService.getPostList()) {
            if (post.getId().equals(id)) {
                post.setContent(updatedPost.getContent());
                post.setTitle(updatedPost.getTitle());
            }
        }
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
        // TODO: add a public method in UserService to actually delete a Post by ID. Invoke that method here
        userService.deletePostById(id);
    }
}
