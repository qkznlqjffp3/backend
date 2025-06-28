package team3.goodbyebug.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team3.goodbyebug.dto.PostResponse;
import team3.goodbyebug.dto.UserProfileResponse;
import team3.goodbyebug.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {

    private final UserService userService;

    // 1. 내 프로필 정보 조회
    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getMyProfile(Principal principal) {
        String username = principal.getName();
        return ResponseEntity.ok(userService.getUserProfile(username));
    }

    // 2. 진행중인 게시글 조회 (open + matched)
    @GetMapping("/posts/in-progress")
    public ResponseEntity<List<PostResponse>> getInProgressPosts(Principal principal) {
        String username = principal.getName();
        Long userId = userService.getUserIdByUsername(username);
        List<PostResponse> posts = userService.getPostsByUserIdAndStatuses(userId, List.of("open", "matched"));
        return ResponseEntity.ok(posts);
    }

    // 3. 완료된 게시글 조회 (done)
    @GetMapping("/posts/completed")
    public ResponseEntity<List<PostResponse>> getCompletedPosts(Principal principal) {
        String username = principal.getName();
        Long userId = userService.getUserIdByUsername(username);
        List<PostResponse> posts = userService.getPostsByUserIdAndStatuses(userId, List.of("done"));
        return ResponseEntity.ok(posts);
    }
}
