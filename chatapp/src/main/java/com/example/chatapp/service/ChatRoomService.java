package com.example.chatapp.service;

import com.example.chatapp.dto.ChatRoomRequestDTO;
import com.example.chatapp.dto.ChatRoomResponseDTO;
import com.example.chatapp.entity.ChatRoom;
import com.example.chatapp.repository.ChatRoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    // MARK: 응용기능
//
//    // 채팅방 목록조회
    @Transactional
    public List<ChatRoomResponseDTO> findAllAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<ChatRoom> chatRoomList = this.chatRoomRepository.findAll(sort);
        return chatRoomList.stream().map(ChatRoomResponseDTO::new).collect(Collectors.toList());
    }
//
//    @Transactional
//    public List<ChatRoomResponseDTO> findAllDesc() {
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        List<ChatRoom> chatRoomList = this.chatRoomRepository.findAll(sort);
//        return chatRoomList.stream().map(ChatRoomResponseDTO::new).collect(Collectors.toList());
//    }
//
//    /** ChatRoom 검색목록조회 - 작성순, List */
//    @Transactional
//    public List<ChatRoomResponseDTO> findAllByRoomNameAsc(String roomName) {
//        Sort sort = Sort.by(Sort.Direction.ASC, "id");
//        List<ChatRoom> chatRoomList = this.chatRoomRepository.findAllByRoomNameContaining(roomName, sort);
//        return chatRoomList.stream().map(ChatRoomResponseDTO::new).collect(Collectors.toList());
//    }
//
//    @Transactional
//    public List<ChatRoomResponseDTO> findAllByRoomNameDesc(String roomName) {
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        List<ChatRoom> chatRoomList = this.chatRoomRepository.findAllByRoomNameContaining(roomName, sort);
//        return chatRoomList.stream().map(ChatRoomResponseDTO::new).collect(Collectors.toList());
//    }

    // MARK: 기본기능

    // 채팅방 id로 조회
    @Transactional
    public ChatRoomResponseDTO findById(final Long id) {
        ChatRoom entity = this.chatRoomRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatRoom이 존재하지 않습니다. id = " + id));
        return new ChatRoomResponseDTO(entity);
    }

    // 채팅방 생성
    @Transactional
    public Long save(final ChatRoomRequestDTO requestDTO) {
        return this.chatRoomRepository.save(requestDTO.toEntity()).getId();
    }

    // 채팅방 수정
    @Transactional
    public Long update(final Long id, ChatRoomRequestDTO requestDTO) {
        ChatRoom entity = this.chatRoomRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatRoom이 존재하지 않습니다. id = " + id));
        return entity.update(requestDTO);
    }

    // 채팅방 삭제
    public void delete(final Long id) {
        ChatRoom entity = this.chatRoomRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatRoom이 존재하지 않습니다. id = " + id));
        this.chatRoomRepository.delete(entity);
    }
}
