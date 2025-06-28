package team3.goodbyebug.dto;


import team3.goodbyebug.domain.ChatRoom;
import team3.goodbyebug.domain.Message;
import team3.goodbyebug.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class AddChatMessageRequest {
    private String payload;
    public Message toEntity(ChatRoom chatRoom, User sender, User receiver) {
        return Message.builder()
                .payload(payload)
                .sender(sender)
                .receiver(receiver)
                .chatRoom(chatRoom)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
