package team3.goodbyebug.controller;

import team3.goodbyebug.service.ApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class ApplyController {

    private final ApplyService applyService;

    // 1. 글에 지원하기
    @PostMapping("/{postId}/apply")
    public ResponseEntity<String> apply(@PathVariable Long postId, @RequestBody Long userId) {
        applyService.applyToPost(postId, userId);
        return ResponseEntity.ok("지원이 완료되었습니다.");
    }

    // 2. 지원자 목록 조회
    @GetMapping("/{postId}/applicants")
    public ResponseEntity<List<Long>> getApplicants(@PathVariable Long postId) {
        return ResponseEntity.ok(applyService.getApplicantIds(postId));
    }

    // 3. 지원자 선택
    @PostMapping("/{postId}/select/{applicantId}")
    public ResponseEntity<String> selectApplicant(@PathVariable Long postId, @PathVariable Long applicantId) {
        applyService.selectApplicant(postId, applicantId);
        return ResponseEntity.ok("지원자가 선택되었습니다.");
    }
}
