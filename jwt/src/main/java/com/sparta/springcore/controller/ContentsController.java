package com.sparta.springcore.controller;

import com.sparta.springcore.dto.ContentsRequestDto;
import com.sparta.springcore.model.Contents;
import com.sparta.springcore.security.FormLoginSuccessHandler;
import com.sparta.springcore.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContentsController {

    private final com.sparta.springcore.repository.ContentsRepository ContentsRepository;
    private final ContentsService ContentsService;

    // 게시글 조회
    @GetMapping("/api/contents")
    public List<Contents> getContents() {
        return ContentsRepository.findAllByOrderByCreatedAtDesc();
    }

    // 게시글 디테일 조회
    @GetMapping("/api/contents/{id}")
    public Contents getContents(@PathVariable Long id) {
        Contents contents =  ContentsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("id가 존재하지 않습니다."));
        return contents;
    }

    // 게시글 작성
    @PostMapping("/api/contents")
    public Contents createContents(@RequestBody ContentsRequestDto requestDto, @AuthenticationPrincipal FormLoginSuccessHandler.UserDetailsImpl userDetails) {
        // 로그인 되어 있는 ID의 username
        String username = userDetails.getUser().getUsername();
        Contents contents = ContentsService.createContents(requestDto, username);
        return contents;
    }

    // 게시글 수정
    @PutMapping("/api/contents/{id}")
    public Long updateContents(@PathVariable Long id, @RequestBody ContentsRequestDto requestDto) {
        ContentsService.update(id, requestDto);
        return id;
    }

    // 게시글 삭제
    @DeleteMapping("/api/contents/{id}")
    public Long deleteContents(@PathVariable Long id) {
        ContentsRepository.deleteById(id);
        return id;
    }
}