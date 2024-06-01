package com.example.chatapp.controller;

import com.example.chatapp.dto.ChatRoomRequestDTO;
import com.example.chatapp.dto.ChatRoomResponseDTO;
import com.example.chatapp.dto.MemberDTO;
import com.example.chatapp.entity.ChatRoom;
import com.example.chatapp.service.ChatRoomService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.Builder;

import java.io.IOException;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    @PostMapping("/chatroom")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model){
        log.info("@ChatRoomController, GET()");
        String memberNickName = memberDTO.getNickName();
        session.setAttribute("loginNickName", memberNickName);
        log.info("입력된 닉네임: " + memberNickName);
        // 로그인을 시도한 닉네임을 세션 정보에 저장
        List<ChatRoomResponseDTO> chatRoomDTOList = chatRoomService.findAllAsc();
        model.addAttribute("chatRoomList", chatRoomDTOList);
        return "list";
//        return "chater";
    }

    @GetMapping("/chatroom")
    public String findAll(Model model) {
        // DB에서 전체 게시글 데이터를 가져와서 list.html 에 보여준다.
        List<ChatRoomResponseDTO> chatRoomDTOList = chatRoomService.findAllAsc();
        model.addAttribute("chatRoomList", chatRoomDTOList);
        return "list";
    }

    @PostMapping("/chatroom/create")
    public String create(@ModelAttribute ChatRoomRequestDTO requestDTO) throws IOException {
        System.out.println("roomName = " + requestDTO.getRoomName());
        ChatRoomRequestDTO chatRoomRequestDTO = ChatRoomRequestDTO.builder()
                .roomName(requestDTO.getRoomName())
                .build();
        chatRoomService.save(chatRoomRequestDTO);
        return "redirect:/chatroom"; // getMapping으로 가겠지?
    }
}
