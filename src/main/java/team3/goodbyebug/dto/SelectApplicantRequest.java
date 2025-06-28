package team3.goodbyebug.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SelectApplicantRequest {
    private Long postId;
    private Long userId;  // 선택될 지원자의 ID
}
