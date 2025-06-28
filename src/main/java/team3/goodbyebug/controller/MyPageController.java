package team3.goodbyebug.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team3.goodbyebug.dto.UserProfileResponse;
import team3.goodbyebug.domain.Post;
import team3.goodbyebug.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;

    // 1. ID(PK)를 통해 내 프로필 정보 조회
    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getMyProfile(String username) {
        return ResponseEntity.ok(userService.getUserProfile(username));
    }


    // 2. 진행중인 게시글 조회 (open + matched)
    @GetMapping("/posts/in-progress")
    public ResponseEntity<List<Post>> getInProgressPosts(Principal principal) {
        String username = principal.getName();
        return ResponseEntity.ok(userService.getPostsByStatuses(username, List.of("open", "matched")));
    }

    // 3. 완료된 게시글 조회 (done)
    @GetMapping("/posts/completed")
    public ResponseEntity<List<Post>> getCompletedPosts(Principal principal) {
        String username = principal.getName();
        return ResponseEntity.ok(userService.getPostsByStatuses(username, List.of("done")));
    }
}
