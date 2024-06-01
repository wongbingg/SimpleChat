package com.example.chatapp.service;

import com.example.chatapp.dto.ChatMessageRequestDTO;
import com.example.chatapp.dto.ChatMessageResponseDTO;
import com.example.chatapp.entity.ChatMessage;
import com.example.chatapp.entity.ChatRoom;
import com.example.chatapp.repository.ChatMessageRepository;
import com.example.chatapp.repository.ChatRoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatMessageService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    @Transactional
    public ChatMessageResponseDTO findById(final Long chatMessageId) {
        ChatMessage chatMessageEntity = this.chatMessageRepository.findById(chatMessageId).orElseThrow(
                () -> new IllegalArgumentException("해당 chatmessage가 존재하지 않습니다. chatMessageId = " + chatMessageId));
        return new ChatMessageResponseDTO(chatMessageEntity);
    }

    @Transactional
    public Long save(final Long chatRoomId, final ChatMessageRequestDTO requestDTO) {
        ChatRoom chatRoomEntity = this.chatRoomRepository.findById(chatRoomId).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatRoom이 존재하지 않습니다. chatRoomId = " + chatRoomId));
        requestDTO.setChatRoom(chatRoomEntity);
        return this.chatMessageRepository.save(requestDTO.toEntity()).getId();
    }

    @Transactional
    public void delete(final Long chatMessageId) {
        ChatMessage chatMessageEntity = this.chatMessageRepository.findById(chatMessageId).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatMessage가 존재하지 않습니다. chatMessageId = " + chatMessageId)
        );
        this.chatMessageRepository.delete(chatMessageEntity);
    }



//    /** 특정 채팅방 ChatMessage 목록조회 - 작성순, List, ChatRoomId 검색 */
//    @Transactional
//    public List<ChatMessageResponseDTO> findAllByChatRoomIdAsc(final Long chatRoomId) {
//        ChatRoom chatRoomEntity = this.chatRoomRepository.findById(chatRoomId).orElseThrow(
//                () -> new IllegalArgumentException("해당 ChatRoom이 존재하지 않습니다. chatRoomId = " + chatRoomId));
//        Sort sort = Sort.by(Sort.Direction.ASC, "id");
//        List<ChatMessage> chatMessageList = this.chatMessageRepository.findAllByChatRoom(chatRoomEntity, sort);
//        return chatMessageList.stream().map(ChatMessageResponseDTO::new).collect(Collectors.toList());
//    }
//
//    /** 특정 채팅방 ChatMessage 목록조회 - 최신순, List, ChatRoomId 검색 */
//    @Transactional
//    public List<ChatMessageResponseDTO> findAllByChatRoomIdDesc(final Long chatRoomId) {
//        ChatRoom chatRoomEntity = this.chatRoomRepository.findById(chatRoomId).orElseThrow(
//                () -> new IllegalArgumentException("해당 ChatRoom이 존재하지 않습니다. chatRoomId = " + chatRoomId));
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        List<ChatMessage> chatMessageList = this.chatMessageRepository.findAllByChatRoom(chatRoomEntity, sort);
//        return chatMessageList.stream().map(ChatMessageResponseDTO::new).collect(Collectors.toList());
//    }
}
