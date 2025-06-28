package team3.goodbyebug.dto;

import lombok.Builder;
import lombok.Getter;
import team3.goodbyebug.domain.ApplyDomain;

@Getter
public class ApplyResponse {

    private Long userId;
    private String username;
    private boolean selected;

    @Builder
    public ApplyResponse(Long userId, String username, boolean selected) {
        this.userId = userId;
        this.username = username;
        this.selected = selected;
    }

    public static ApplyResponse from(ApplyDomain apply) {
        return ApplyResponse.builder()
                .userId(apply.getUser().getId())              // 사용자 ID
                .username(apply.getUser().getUsername())      // 사용자 이름
                .selected(apply.isSelected())                 // 선택 여부
                .build();
    }
}
