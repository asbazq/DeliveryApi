package com.sparta.week03.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReadRequestDto { // 목록보기
    private Long id;
    private LocalDateTime createdAt;
    private String title; // 보완상 문제로 private
    private String username;



    public ReadRequestDto(Memo memo) {
        this.id = memo.getId();
        this.createdAt = memo.getCreatedAt();
        this.title = memo.getTitle();
        this.username = memo.getUsername();

    }

}