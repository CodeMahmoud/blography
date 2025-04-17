package com.mahmoud.blog.domain.repositories;

import com.mahmoud.blog.domain.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepositroy extends JpaRepository<Post, UUID> {
}
