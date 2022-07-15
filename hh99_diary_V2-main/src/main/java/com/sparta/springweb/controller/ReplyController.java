package com.sparta.springweb.controller;

import com.sparta.springweb.dto.ReplyRequestDto;
import com.sparta.springweb.model.Reply;
import com.sparta.springweb.repository.ReplyRepository;
import com.sparta.springweb.security.provider.UserDetailsImpl;
import com.sparta.springweb.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController<userId> {

    private final ReplyRepository ReplyRepository;
    private final ReplyService ReplyService;

    @GetMapping("/api/reply/{postId}")
    public List<Reply> getReply(@PathVariable Long postId) {
        return ReplyService.getReply(postId);
    }

    // 댓글 작성
    @PostMapping("/api/reply")
    public boolean createReply(@RequestBody ReplyRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 확인하기
        if (userDetails != null) {
            Long userId = userDetails.getUser().getId();
            ReplyService.createReply(requestDto, userId);
            return true;
        }
        return false;
    }

    // 댓글 수정
    @PutMapping("/api/reply/{id}")
    public Long updateReply(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto) {
        ReplyService.update(id, requestDto);
        return id;
    }

    // 댓글 삭제
    @DeleteMapping("/api/reply/{id}")
    public Long deleteReply(@PathVariable Long id) {
        ReplyRepository.deleteById(id);
        return id;
    }
}