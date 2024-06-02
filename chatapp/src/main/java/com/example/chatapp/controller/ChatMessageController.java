package com.example.chatapp.controller;

import com.example.chatapp.dto.ChatMessageResponseDTO;
import com.example.chatapp.dto.ChatRoomRequestDTO;
import com.example.chatapp.dto.ChatRoomResponseDTO;
import com.example.chatapp.entity.ChatRoom;
import com.example.chatapp.service.ChatMessageService;
import com.example.chatapp.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ChatMessageController {
    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    @GetMapping("chatroom/{id}")
    public String enterChatRoom(@PathVariable Long id, Model model) {
        List<ChatMessageResponseDTO> chatMessageResponseDTOList = chatMessageService.findAllByChatRoomIdAsc(id);
        model.addAttribute("messageList", chatMessageResponseDTOList);
        ChatRoomResponseDTO chatRoomDTO = chatRoomService.findById(id);
        model.addAttribute("chatRoom", chatRoomDTO);
        return "chater";
    }
}
