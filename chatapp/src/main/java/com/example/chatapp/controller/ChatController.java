package com.example.chatapp.controller;

import com.example.chatapp.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class ChatController {

    @PostMapping("/chat")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        log.info("@ChatController, chat GET()");
        String memberNickName = memberDTO.getNickName();
        session.setAttribute("loginNickName", memberNickName);
        log.info("입력된 닉네임: " + memberNickName);
        // 로그인을 시도한 닉네임을 세션 정보에 저장
        return "chater";
    }
}