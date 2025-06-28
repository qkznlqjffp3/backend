package team3.goodbyebug.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team3.goodbyebug.dto.AddPostRequest;
import team3.goodbyebug.dto.ApiResponse;
import team3.goodbyebug.dto.PostResponse;
import team3.goodbyebug.service.PostService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/posts")
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllPosts() {
        // 전체 글 목록
        List<PostResponse> posts = postService.getAllPosts();
        return ResponseEntity.ok(new ApiResponse(true, 200, "게시글 조회 성공", posts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getPostById(@PathVariable Long id) {
        // 글 상세 조회
        PostResponse response = postService.getPost(id);
        return ResponseEntity.ok(new ApiResponse(true,200,"게시글 조회 성공", response));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createPost(@RequestBody AddPostRequest request) {
        // 글 작성
        PostResponse response = postService.addPost(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse(true,201,"게시글 등록 성공",response));
    }

}
