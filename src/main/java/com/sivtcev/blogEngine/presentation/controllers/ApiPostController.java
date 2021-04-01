package com.sivtcev.blogEngine.presentation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApiPostController {

    @GetMapping("/api/post")
    private void getPostList(){}

    @GetMapping("/api/post/search")
    private void postsSearch(){}

    @GetMapping("/api/post/byDate")
    private void getPostsByDate(){}

    @GetMapping("/api/post/byTag")
    private void getPostsByTag(){}

    @GetMapping("/api/post/{id}")
    private void getPostByID(){}

    @GetMapping("/api/post/moderation")
    private void getPostsOnModeration(){}

    @GetMapping("/api/post/my")
    private void getCurrentUserPosts(){}

    @PostMapping("/api/post/")
    private void addPost(){}

    @PutMapping("/api/post/{id}")
    private void editPost(){}

    @PostMapping("/api/post/like")
    private void addPostLike(){}

    @PostMapping("/api/post/dislike")
    private void addPostDislike(){}
}
