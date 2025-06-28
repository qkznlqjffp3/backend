package team3.goodbyebug.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team3.goodbyebug.domain.Post;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PostResponse {
    private final Long id;
    private final Long user_id;
    private final String title;
    private final String content;
    private final String img_url;
    private final String status;
    private final int bug_size;
    private final String bug_type;
    private final Long price;
    private final LocalDateTime createdAt;

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .user_id(post.getUserId())
                .title(post.getTitle())
                .content(post.getContent())
                .img_url(post.getImg_url())
                .status(post.getStatus())
                .bug_size(post.getBug_size())
                .bug_type(post.getBug_type())
                .price(post.getPrice())
                .createdAt(post.getCreatedAt())
                .build();
    }

}
