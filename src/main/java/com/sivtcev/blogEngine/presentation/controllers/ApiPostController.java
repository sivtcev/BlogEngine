package com.sivtcev.blogEngine.presentation.controllers;

import com.sivtcev.blogEngine.domain.services.PostService;
import com.sivtcev.blogEngine.presentation.api.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ApiPostController {

    public final PostService postService;

    /**
     * @return a list of posts with related information for the main page and the "New", "Most discussed",
     * "Best", and "Old" subsections.
     *
     * @param offset offset from 0 for paginated output. Default value: 0
     * @param limit the number of posts to display. Default value: 10
     * @param mode sorting mode. Value options: recent (sorted by date, recently first),
     *             popular (sorted by comment count, posts without comments are displayed),
     *             best (sorted by like count, posts without likes are displayed),
     *             early (sorted by date, least recently first). Default value: 10
     *
     * Authorisation is not required
     */
    @GetMapping("/api/post")
    public ResponseEntity<PostResponse> getPostList(
            @RequestParam(name = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(name = "mode", required = false, defaultValue = "recent") String mode){
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/api/post/search")
    public void postsSearch(){}

    @GetMapping("/api/post/byDate")
    public void getPostsByDate(){}

    @GetMapping("/api/post/byTag")
    public void getPostsByTag(){}

    @GetMapping("/api/post/{id}")
    public void getPostByID(){}

    @GetMapping("/api/post/moderation")
    public void getPostsOnModeration(){}

    @GetMapping("/api/post/my")
    public void getCurrentUserPosts(){}

    @PostMapping("/api/post/")
    public void addPost(){}

    @PutMapping("/api/post/{id}")
    public void editPost(){}

    @PostMapping("/api/post/like")
    public void addPostLike(){}

    @PostMapping("/api/post/dislike")
    public void addPostDislike(){}
}
