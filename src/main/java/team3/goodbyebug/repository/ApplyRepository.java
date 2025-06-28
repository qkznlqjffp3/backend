package team3.goodbyebug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.goodbyebug.domain.Apply;
import team3.goodbyebug.domain.Post;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {

    // 특정 게시글에 지원한 지원자 목록 조회
    List<Apply> findByPost(Post post);

    // 게시글 ID와 사용자 ID로 Apply 조회
    Optional<Apply> findByPostIdAndUserId(Long post_id, Long user_id);
}
