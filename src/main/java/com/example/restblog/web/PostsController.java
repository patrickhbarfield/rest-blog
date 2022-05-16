package com.example.restblog.web;
import com.example.restblog.data.Post;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {
   @GetMapping
   public List<Post> getAll() {
      List<Post> posts = new ArrayList<>();
      posts.add(new Post(1L, "Argonne National Laboratory", "A Real-Time Intelligent Speed Optimization Planner Using Reinforcement Learning"));
      posts.add(new Post(2L, "National Renewable Energy Laboratory", "Shared Automated Vehicle Fleet Operations for First-Mile Last-Mile Transit Connections with Dynamic Pooling"));
      posts.add(new Post(3L, "Oak Ridge National Laboratory", "Hybrid Neural Network Modeling for Multiple Intersections along Signalized Arterials - Current Situation and Some New Results"));
      return posts;
   }

   @GetMapping("/{id}")
   public Post getById(@PathVariable Long id) {
      return new Post(id, "Argonne National Laboratory", "A Real-Time Intelligent Speed Optimization Planner Using Reinforcement Learning");
   }

   @PostMapping
   public void createPost(@RequestBody Post toAdd) {
      System.out.println(toAdd);
   }

   @PutMapping("{id}")
   public void updatePost(@PathVariable Long id, @RequestBody Post post) {
      System.out.println("updating post");
   }

   @DeleteMapping("{id}")
   public void deletePost(@PathVariable Long id) {
      System.out.println("deleting post");
   }
}
