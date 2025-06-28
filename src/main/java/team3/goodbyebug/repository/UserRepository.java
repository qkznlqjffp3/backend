package team3.goodbyebug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.goodbyebug.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // username(고유식별 가능하도록 unique 설정해둠!!)으로 유저 검색
    Optional<User> findByUsername(String username);
}
