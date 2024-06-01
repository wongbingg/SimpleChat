package com.example.chatapp.repository;

import com.example.chatapp.entity.ChatRoom;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    ChatRoom findByRoomName(String roomName);

    List<ChatRoom> findAllByRoomName(String roomName);
    List<ChatRoom> findAllByRoomName(String roomName, Sort sort);
    List<ChatRoom> findAllByRoomNameContaining(String roomName);
    List<ChatRoom> findAllByRoomNameContaining(String roomName, Sort sort);
}
