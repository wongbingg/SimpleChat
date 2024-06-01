package com.example.chatapp.dto;

import com.example.chatapp.entity.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
