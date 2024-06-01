package com.example.chatapp.entity;

import com.example.chatapp.dto.ChatRoomRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class ChatRoom extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomName;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.REMOVE)
    private List<ChatMessage> chatMessageList;

    @Builder
    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    public Long update(ChatRoomRequestDTO requestDTO) {
        this.roomName = requestDTO.getRoomName();
        return this.id;
    }
}
