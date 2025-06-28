package team3.goodbyebug.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String location;

    private String profileImageUrl;

    private Boolean canHandleFlyingBug; // 날벌레 잡을 수 있음
    private Boolean canHandleCrawlingBug; // 기어다니는 벌레 잡을 수 있음

    private String bugSize;
}
