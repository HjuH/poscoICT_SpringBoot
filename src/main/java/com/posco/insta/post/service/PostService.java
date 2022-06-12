package com.posco.insta.post.service;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;

import java.util.List;

public interface PostService {
    List<PostDto> getPost();
    SelectPostJoinUserDto getPostsById(PostDto postDto);
    List<SelectPostJoinUserDto> getPostsByUserId(PostDto postDto);
    Integer deletePostByUserIdAndId(PostDto postDto);
    List<SelectPostJoinUserDto> getPostsByNotUserId(PostDto postDto);
    Integer updateMyPost(PostDto postDto);
    Integer postPost(PostDto postDto);
    List<SelectPostJoinUserDto> findPostByKey(String key);
    List<SelectPostJoinUserDto> getPostsByMyFollowing(PostDto postDto);
}