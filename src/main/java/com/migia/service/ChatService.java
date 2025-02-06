package com.migia.service;

import com.migia.model.Chat;
import com.migia.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public Chat sendMessage(Chat chat) {
        return chatRepository.save(chat);
    }

    public List<Chat> getChatBetweenUsers(String senderUsername, String receiverUsername) {
        return chatRepository.findBySenderUsernameAndReceiverUsername(senderUsername, receiverUsername);
    }
}