package team3.goodbyebug.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team3.goodbyebug.domain.ChatRoom;
import team3.goodbyebug.domain.Message;
import team3.goodbyebug.dto.*;
import team3.goodbyebug.repository.ChatRoomRepository;
import team3.goodbyebug.repository.MessageRepository;
import team3.goodbyebug.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRoomRepository chatRoomRepository;
    private final MessageRepository messageRepository;

    //addChatRoom: user 두명 찾아서 리퀘스트에 집어넣기
    @Transactional
    public ChatRoomResponse addChatRoom(long user_id1, long user_id2, AddChatRoomRequest request) {
        User user1 = UserRepository.findById(user_id1)
                .orElseThrow(() -> new EntityNotFoundException());
        User user2 = UserRepository.findById(user_id2)
                .orElseThrow(() -> new EntityNotFoundException());
        ChatRoom chatRoom = request.toEntity(user1, user2);

        chatRoomRepository.save(chatRoom);

        return ChatRoomResponse.of(chatRoom);
    }

    //addMessage: sender, receiver, 채팅방 id 찾아서 리퀘스트 집어넣기
    @Transactional
    public MessageResponse addMessage(long chatRoom_id, long sender_id, long receiver_id, AddChatMessageRequest request) {
        //request 객체의 .toEntity()를 통해 Article 객체 생성
        ChatRoom chatRoom = ChatRoomRepository.findById(chatRoom_id)
                .orElseThrow(() -> new EntityNotFoundException());

        User sender = UserRepository.findById(sender_id)
                .orElseThrow(() -> new EntityNotFoundException());
        User receiver = UserRepository.findById(receiver_id)
                .orElseThrow(() -> new EntityNotFoundException());
        Message message = request.toEntity(chatRoom, sender, receiver);

        messageRepository.save(message);

        return MessageResponse.of(message);
    }

    public List<ChatRoomResponse> getChatRooms(long user_id) {
        return chatRoomRepository.findByUser1_IdOrUser2_Id(user_id, user_id).stream()
                .map(chatRoom -> ChatRoomResponse.of(chatRoom))
                .toList();
    }

    public ChatRoomWithMessagesResponse getChatRoomWithMessages(Long id) {
        //request 객체의 .toEntity()를 통해 Article 객체 생성
        ChatRoom chatRoom = chatRoomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        List<MessageResponse> messages = getRoomMessages(chatRoom);

        return ChatRoomWithMessagesResponse.of(chatRoom, messages);

    }

    private List<MessageResponse> getRoomMessages(ChatRoom chatRoom) {
        return messageRepository.findByChatRoom(chatRoom).stream()
                .map(message -> MessageResponse.of(message))
                .toList();
    }


}
