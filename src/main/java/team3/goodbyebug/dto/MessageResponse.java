package team3.goodbyebug.dto;

import jakarta.persistence.Entity;
import lombok.*;
import team3.goodbyebug.domain.Message;
import team3.goodbyebug.domain.User;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MessageResponse {
    private final Long id;
    private final Long chatRoomId;
    private final User sender;
    private final User receiver;
    private final Long receiverId;
    private final String payload;
    private final LocalDateTime createdAt;


    public static MessageResponse of(Message message){
        return MessageResponse.builder()
                .id(message.getId())
                .chatRoomId(message.getChatRoom().getId())
                .payload(message.getPayload())
                .sender(message.getSender())
                .receiver(message.getReceiver())
                .createdAt(message.getCreatedAt())
                .build();

    }
}
