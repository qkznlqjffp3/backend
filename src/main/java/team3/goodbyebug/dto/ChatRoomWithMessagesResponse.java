package team3.goodbyebug.dto;

import team3.goodbyebug.domain.ChatRoom;
import team3.goodbyebug.domain.User;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class ChatRoomWithMessagesResponse {
    private final Long id;
    private final LocalDateTime createdAt;
    private final User user1;
    private final User user2;
    private final List<MessageResponse> messages;

    public static ChatRoomWithMessagesResponse of(ChatRoom chatRoom, List<MessageResponse> messages) {
        return ChatRoomWithMessagesResponse.builder()
                .id(chatRoom.getId())
                .user1(chatRoom.getUser1())
                .user2(chatRoom.getUser2())
                .createdAt(chatRoom.getCreatedAt())
                .messages(messages)
                .build();
    }
}
