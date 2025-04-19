package com.mahmoud.blog.services;

import com.mahmoud.blog.domain.CreatePostRequest;
import com.mahmoud.blog.domain.dtos.PostDto;
import com.mahmoud.blog.domain.dtos.UpdatePostRequest;
import com.mahmoud.blog.domain.entities.Post;
import com.mahmoud.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
}
