package team3.goodbyebug.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team3.goodbyebug.domain.Post;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddPostRequest {
    private Long user_id;
    private String title;
    private String content;
    private String img_url;
    private String status;
    private int bug_size;
    private String bug_type;
    private Long price;

    public Post toEntity() {
        return Post.builder()
                .user_id(user_id)
                .title(title)
                .content(content)
                .img_url(img_url)
                .status(status)
                .bug_size(bug_size)
                .bug_type(bug_type)
                .price(price)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
