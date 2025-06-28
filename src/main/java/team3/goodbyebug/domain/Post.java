package team3.goodbyebug.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String img_url;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private int bug_size;

    @Column(nullable = false)
    private String bug_type;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Post(Long user_id, String title, String content, String img_url, String status, int bug_size, String bug_type, String location, Long price) {
        this.userId = user_id;
        this.title = title;
        this.content = content;
        this.img_url = img_url;
        this.status = status;
        this.bug_size = bug_size;
        this.bug_type = bug_type;
        this.location = location;
        this.price = price;

    }
}
