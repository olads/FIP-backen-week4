package com.migia.service;

import com.migia.model.Like;
import com.migia.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public Like addLike(Like like) {
        return likeRepository.save(like);
    }

    public Long getLikeCountByPost(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}