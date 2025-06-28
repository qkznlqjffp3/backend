package team3.goodbyebug.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team3.goodbyebug.domain.*;
import team3.goodbyebug.dto.UserProfileResponse;
import team3.goodbyebug.repository.UserRepository;
import team3.goodbyebug.repository.PostRepository;
import team3.goodbyebug.dto.PostResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    // 사용자 ID 기반으로 프로필 정보 가져오기
    @Transactional(readOnly = true)
    public UserProfileResponse getUserProfile(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return UserProfileResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .location(user.getLocation())
                .profileImageUrl(user.getProfileImageUrl())
                .canHandleFlyingBug(user.getCanHandleFlyingBug())
                .canHandleCrawlingBug(user.getCanHandleCrawlingBug())
                .bugSize(user.getBugSize())
                .build();
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUserIdAndStatuses(Long userId, List<String> statuses) {
        List<Post> posts = postRepository.findByUserIdAndStatusIn(userId, statuses);

        return posts.stream()
                .map(PostResponse::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public Long getUserIdByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."))
                .getId();
    }

}
