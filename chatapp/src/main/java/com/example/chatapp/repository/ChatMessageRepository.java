package com.example.chatapp.repository;

import com.example.chatapp.entity.ChatMessage;
import com.example.chatapp.entity.ChatRoom;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findAllByChatRoom(ChatRoom chatRoom);
    List<ChatMessage> findAllByChatRoom(ChatRoom chatRoom, Sort sort);
    List<ChatMessage> findAllByMessageContaining(String message);
    List<ChatMessage> findAllByMessageContaining(String message, Sort sort);
}
