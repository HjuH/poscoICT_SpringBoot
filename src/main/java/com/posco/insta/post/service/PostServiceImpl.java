package com.posco.insta.post.service;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import com.posco.insta.post.repository.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;

    @Override
    public List<PostDto> getPost() {
        return postMapper.getPosts();
    }

    @Override
    public List<SelectPostJoinUserDto> getPostsByUserId(PostDto postDto) {
        return postMapper.findPostsByUserId(postDto);
    }

    @Override
    public Integer deletePostByUserIdAndId(PostDto postDto) {
        return postMapper.deletePostByUserIdAndId(postDto);
    }

    @Override
    public List<SelectPostJoinUserDto> getPostsByNotUserId(PostDto postDto) {
        return postMapper.findPostsByNotUserId(postDto);
    }

    @Override
    public Integer updateMyPost(PostDto postDto) {
        return postMapper.updatePostsByUserIdAndId(postDto);
    }

    @Override
    public Integer postPost(PostDto postDto) {
        return postMapper.insertPost(postDto);
    }

    @Override
    public SelectPostJoinUserDto getPostsById(PostDto postDto) {
        return postMapper.getPostsById(postDto);
    }

    @Override
    public List<SelectPostJoinUserDto> findPostByKey(String key) {
        return postMapper.getPostByKey(key);
    }

    @Override
    public List<SelectPostJoinUserDto> getPostsByMyFollowing(PostDto postDto) {
        return postMapper.getPostsByMyFollowing(postDto);
    }
}