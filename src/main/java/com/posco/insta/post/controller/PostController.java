package com.posco.insta.post.controller;

import com.posco.insta.aspect.TokenRequired;
import com.posco.insta.config.SecurityService;
import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import com.posco.insta.post.service.PostServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@TokenRequired
public class PostController {
    @Autowired
    PostDto postDto;
    @Autowired
    PostServiceImpl postService;
    @Autowired
    SecurityService securityService;

    @GetMapping("/")
    public List<PostDto> getPost() {
        return postService.getPost();
    }

    @GetMapping("/my")
    public List<SelectPostJoinUserDto> getMyPosts() {
        postDto.setUserId(securityService.getIdAtToken());
        return postService.getPostsByUserId(postDto);
    }

    @GetMapping("/{id}")
    public SelectPostJoinUserDto getPostsById(@PathVariable String id) {
        postDto.setUserId(Integer.valueOf(id));
        return postService.getPostsById(postDto);
    }

    @DeleteMapping("/{id}")
    public Integer deleteMyPost(@PathVariable String id) {
        postDto.setId(Integer.valueOf(id));
        postDto.setUserId(securityService.getIdAtToken());
        return postService.deletePostByUserIdAndId(postDto);
    }

    @GetMapping("/other")
    public List<SelectPostJoinUserDto> getOtherPosts() {
        postDto.setUserId(securityService.getIdAtToken());
        return postService.getPostsByNotUserId(postDto);
    }

    @PutMapping("/{id}")
    public Integer updateMyPost(@RequestBody PostDto postDto, @PathVariable String id) {
        postDto.setUserId(securityService.getIdAtToken());
        postDto.setId(Integer.valueOf(id));
        return postService.updateMyPost(postDto);
    }

    @PostMapping("/")
    public Integer postPost(@RequestBody PostDto postDto) {
        postDto.setUserId(securityService.getIdAtToken());
        return postService.postPost(postDto);
    }

    @GetMapping("/key/{key}")
    public List<SelectPostJoinUserDto> getPostsLikeKey(@PathVariable String key) {
        return postService.findPostByKey(key);
    }

    @GetMapping("/following")
    @Operation(description = "내가 follow 한 사람(내가 following 으로 있고, follower 인 사람)의 게시물")
    public List<SelectPostJoinUserDto> getPostsByMyFollowing() {
        postDto.setUserId(securityService.getIdAtToken());
        return postService.getPostsByMyFollowing(postDto);
    }
}