package com.migia.repository;

import com.migia.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    // Custom query to count likes for a post
    Long countByPostId(Long postId);
}