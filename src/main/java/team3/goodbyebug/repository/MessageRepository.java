package team3.goodbyebug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team3.goodbyebug.domain.ChatRoom;
import team3.goodbyebug.domain.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findByChatRoom(ChatRoom chatRoom);
}
