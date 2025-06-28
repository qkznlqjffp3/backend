package team3.goodbyebug.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team3.goodbyebug.domain.Post;
import team3.goodbyebug.dto.AddPostRequest;
import team3.goodbyebug.dto.PostResponse;
import team3.goodbyebug.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 글 작성
    @Transactional
    public PostResponse addPost(AddPostRequest request) {
        Post post=request.toEntity();

        post = postRepository.save(post);
        return PostResponse.of(post);
    }

    // 전체 글 조회
    public List<PostResponse> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        List<PostResponse> postResponseList = postList.stream()
                .map(post -> PostResponse.of(post))
                .toList();
        return postResponseList;
    }

    // 단일 글 조회
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다: id=" + id));
        return PostResponse.of(post);

    }
}
