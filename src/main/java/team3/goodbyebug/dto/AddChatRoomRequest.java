package team3.goodbyebug.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team3.goodbyebug.domain.User;
//user 머지 후 연결 가능
import team3.goodbyebug.domain.ChatRoom;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class AddChatRoomRequest {
    public ChatRoom toEntity(User user1, User user2){
        return ChatRoom.builder()
                .user1(user1)
                .user2(user2)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
