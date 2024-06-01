package com.example.chatapp.dto;

import com.example.chatapp.entity.ChatRoom;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class ChatRoomResponseDTO {
    private Long id;
    private String roomName;
    private String createdDate;
    private String updatedDate;

    public ChatRoomResponseDTO(ChatRoom entity) {
        this.id = entity.getId();
        this.roomName = entity.getRoomName();
        this.createdDate = entity.getCreatedDate()
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.updatedDate = entity.getUpdatedDate()
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }
}
