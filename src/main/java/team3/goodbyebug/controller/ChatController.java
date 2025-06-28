package team3.goodbyebug.controller;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import team3.goodbyebug.domain.Message;
import team3.goodbyebug.dto.*;
import team3.goodbyebug.service.ChatService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/chats")
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<ApiResponse> createChatRoom(@PathVariable long user_id1, @PathVariable long user_id2, @RequestBody AddChatRoomRequest request){
        ChatRoomResponse response=chatService.addChatRoom(user_id1, user_id2, request);
        return ResponseEntity.ok(new ApiResponse(true,201,"채팅방 생성 성공",response));
    }
    @GetMapping
    public ResponseEntity<ApiResponse> readChatRoom(@PathVariable long user_id){
        List<ChatRoomResponse> response=chatService.getChatRooms(user_id);
        return ResponseEntity.ok(new ApiResponse(true,201,"채팅방 조회 성공",response));
    }
    @PostMapping("/{chatRoomId}/messages")
    public ResponseEntity<ApiResponse> createChatMessages(@PathVariable long chatRoom_id, @PathVariable long sender_id, @PathVariable long receiver_id, @RequestBody AddChatMessageRequest request){
        MessageResponse response=chatService.addMessage(chatRoom_id, sender_id, receiver_id, request);
        return ResponseEntity.ok(new ApiResponse(true,201,"메시지 생성 성공",response));
    }

    @GetMapping("/{chatRoomId}/messages")
    public ResponseEntity<ApiResponse> readChatMessages(@PathVariable long chatRoom_id){
        ChatRoomWithMessagesResponse response=chatService.getChatRoomWithMessages(chatRoom_id);
        return ResponseEntity.ok(new ApiResponse(true, 200, "메시지 조회 성공", response));
    }

}
