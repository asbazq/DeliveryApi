package com.sparta.springcore.controller;

import com.sparta.springcore.dto.ReplyRequestDto;
import com.sparta.springcore.model.Reply;
import com.sparta.springcore.repository.ReplyRepository;
import com.sparta.springcore.security.FormLoginSuccessHandler;
import com.sparta.springcore.service.ReplyService;
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
    public boolean createReply(@RequestBody ReplyRequestDto requestDto, @AuthenticationPrincipal FormLoginSuccessHandler.UserDetailsImpl userDetails) {
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