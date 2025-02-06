package com.migia.repository;

import com.migia.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    // Custom query to find chats between two users
    List<Chat> findBySenderUsernameAndReceiverUsername(String senderUsername, String receiverUsername);
}