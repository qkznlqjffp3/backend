package team3.goodbyebug.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team3.goodbyebug.domain.Post;
import team3.goodbyebug.domain.User;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {

    private Long userId;
    private String username;
    private String location;
    private String profileImageUrl;

    private Boolean canHandleFlyingBug;
    private Boolean canHandleCrawlingBug;
    private int bugSize;  // 예: S / M / L 이렇게 사용

    public static UserProfileResponse of(User user) {
        return UserProfileResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .location(user.getLocation())
                .profileImageUrl(user.getProfileImageUrl())
                .canHandleFlyingBug(user.getCanHandleFlyingBug())
                .canHandleCrawlingBug(user.getCanHandleCrawlingBug())
                .build();
    }

}
