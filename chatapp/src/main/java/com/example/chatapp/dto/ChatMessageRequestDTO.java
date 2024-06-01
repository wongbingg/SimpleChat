package com.example.chatapp.dto;

import com.example.chatapp.entity.ChatMessage;
import com.example.chatapp.entity.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatMessageRequestDTO {
    private String sender;
    private String message;
    private ChatRoom chatRoom;

    @Builder
    public ChatMessageRequestDTO(String sender, String message, ChatRoom chatRoom) {
        this.sender = sender;
        this.message = message;
        this.chatRoom = chatRoom;
    }

    public ChatMessage toEntity() {
        return ChatMessage.builder()
                .sender(this.sender)
                .message(this.message)
                .chatRoom(this.chatRoom)
                .build();
    }
}
