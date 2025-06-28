package team3.goodbyebug.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team3.goodbyebug.domain.Apply;
import team3.goodbyebug.domain.Post;
import team3.goodbyebug.domain.User;
import team3.goodbyebug.dto.ApplyRequest;
import team3.goodbyebug.dto.ApplyResponse;
import team3.goodbyebug.dto.SelectApplicantRequest;
import team3.goodbyebug.repository.ApplyRepository;
import team3.goodbyebug.repository.PostRepository;
import team3.goodbyebug.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final ApplyRepository applyRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // ✅ 1. 글에 지원하기
    @Transactional
    public ApplyResponse applyToPost(Long postId, ApplyRequest request) {
        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new EntityNotFoundException("해당 글을 찾을 수 없습니다."));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("해당 사용자를 찾을 수 없습니다."));

        Apply apply = Apply.builder()
                .post(post)
                .user(user)
                .selected(false)
                .build();

        applyRepository.save(apply);

        return ApplyResponse.of(apply);
    }

    // ✅ 2. 해당 글의 지원자 리스트 조회
    @Transactional(readOnly = true)
    public List<Apply> getApplicants(Long postId) {
        return applyRepository.findByPost(postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("해당 글을 찾을 수 없습니다.")));
    }

    // ✅ 3. 지원자 선택 처리
    @Transactional
    public void selectApplicant(SelectApplicantRequest request) {
        Apply apply = applyRepository.findByPostIdAndUserId(request.getPostId(), request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("해당 지원 정보를 찾을 수 없습니다."));

        apply.setSelected(true);
    }

    public List<ApplyResponse> getApplicantIds(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException());
        return applyRepository.findByPost(post).stream()
                .map(apply -> ApplyResponse.of(apply))
                .toList();
    }
}
