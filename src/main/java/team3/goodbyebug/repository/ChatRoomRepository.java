package team3.goodbyebug.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.goodbyebug.domain.ChatRoom;

import java.util.List;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {
    // JpaRepository 클래스 상속받음
    // 엔티티 Article과 기본키 타입을 인수로
    List<ChatRoom> findByUser1_IdOrUser2_Id(Long userId1, Long userId2);
}