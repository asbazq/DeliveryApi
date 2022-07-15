package com.sparta.springweb.service;


import com.sparta.springweb.dto.ReplyRequestDto;
import com.sparta.springweb.model.Reply;
import com.sparta.springweb.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final com.sparta.springweb.repository.ReplyRepository ReplyRepository;

    // 댓글 조회
    public List<Reply> getReply(Long postId) {
        return ReplyRepository.findAllByPostidOrderByCreatedAtDesc(postId);
    }

    // 댓글 작성
    @Transactional
    public Reply createReply(ReplyRequestDto requestDto, Long userId) {
        String replyCheck = requestDto.getReply();
        if (replyCheck.contains("script")|| replyCheck.contains("<")||replyCheck.contains(">")){
            Reply reply = new Reply(requestDto, userId,"잘못된 입력입니다(XSS 공격금지)");
            ReplyRepository.save(reply);
            return reply;
        }
        Reply reply = new Reply(requestDto, userId);
        ReplyRepository.save(reply);
        return reply;
    }

    // 댓글 수정
    @Transactional
    public void update(Long id, ReplyRequestDto requestDto) {
        Reply Reply = ReplyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다")
        );
        Reply.update(requestDto);
    }
}