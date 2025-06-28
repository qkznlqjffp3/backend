package team3.goodbyebug.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    // 첫 번째 유저
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user1_id", nullable = false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private User user1;

    // 두 번째 유저
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user2_id", nullable = false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private User user2;


    @Column(nullable = false)
    private LocalDateTime createdAt;

}
