package team3.goodbyebug.dto;

import team3.goodbyebug.domain.ChatRoom;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class ChatRoomResponse {
    private final Long id;
    private final LocalDateTime createdAt;

    public static ChatRoomResponse of(ChatRoom chatRoom) {
        return ChatRoomResponse.builder()
                .id(chatRoom.getId())
                .createdAt(chatRoom.getCreatedAt())
                .build();
    }
}
