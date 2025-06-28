package team3.goodbyebug.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplyRequest {
    private Long postId;
    private Long userId;
}
