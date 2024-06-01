package com.example.chatapp.dto;

import com.example.chatapp.entity.ChatMessage;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class ChatMessageResponseDTO {
    private Long id;
    private String sender;
    private String message;
    private String createdDate;
    private String updatedDate;

    public ChatMessageResponseDTO(ChatMessage entity) {
        this.id = entity.getId();
        this.sender = entity.getSender();
        this.message = entity.getMessage();
        this.createdDate = entity.getCreatedDate()
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.updatedDate = entity.getUpdatedDate()
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }
}
