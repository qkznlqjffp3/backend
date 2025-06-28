package team3.goodbyebug.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String bugSize;  // 예: S / M / L 이렇게 사용
}
