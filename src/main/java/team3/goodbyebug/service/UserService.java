package team3.goodbyebug.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team3.goodbyebug.domain.User;
import team3.goodbyebug.dto.UserProfileResponse;
import team3.goodbyebug.repository.UserRepository;
import team3.goodbyebug.repository.PostRepository;

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
    public List<PostResponse> getPostsByStatuses(String username, List<String> statuses) {
        List<Post> posts = postRepository.findByUserUsernameAndStatusIn(username, statuses);

        return posts.stream()
                .map(post -> PostResponse.builder()
                        .postId(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .status(post.getStatus())
                        .createdAt(post.getCreatedAt())
                        .build())
                .toList();
    }

}
