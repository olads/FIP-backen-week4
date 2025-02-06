package com.migia.repository;

import com.migia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Custom query to find posts by a specific user
    List<Post> findByUserUsername(String username);
}