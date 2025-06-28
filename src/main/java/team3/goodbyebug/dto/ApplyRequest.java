package team3.goodbyebug.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import team3.goodbyebug.domain.Apply;
import team3.goodbyebug.domain.Post;
import team3.goodbyebug.domain.User;

@Getter
@NoArgsConstructor
public class ApplyRequest {
    private Long postId;
    private Long userId;


    public Apply toEntity(Post post, User user) {
        return Apply.builder()
                .post(post)
                .user(user)
                .selected(false)
                .build();
    }
}
