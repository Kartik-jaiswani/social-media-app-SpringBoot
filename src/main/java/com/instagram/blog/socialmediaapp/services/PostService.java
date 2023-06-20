package com.instagram.blog.socialmediaapp.services;

import com.instagram.blog.socialmediaapp.entities.Post;
import com.instagram.blog.socialmediaapp.payload.PostDto;
import com.instagram.blog.socialmediaapp.payload.PostResponse;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto,Integer categoryId,Integer userId);

    //update
    PostDto updatePost(PostDto postDto,Integer postId);

    //delete
    void deletePost(Integer postId);

    //get all posts
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);

    //get single post
    PostDto getPostById(Integer postId);

    //get all posts by category
    List<PostDto> getPostByCategory(Integer categoryId);

    //get all posts by user
//    PostResponse getPostByUser(Integer userId,Integer pageNumber, Integer pageSize);
    List<PostDto> getPostByUser(Integer userId);

    //search a post by Keyword
    List<PostDto> searchPosts(String keyword);
}
