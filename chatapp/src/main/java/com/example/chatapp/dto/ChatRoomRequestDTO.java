package com.example.chatapp.dto;

import com.example.chatapp.entity.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomRequestDTO {
    private String roomName;

    @Builder
    public ChatRoomRequestDTO(String roomName) {
        this.roomName = roomName;
    }

    public ChatRoom toEntity() {
        return ChatRoom.builder()
                .roomName(this.roomName)
                .build();
    }
}
