package com.sparta.week03.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostRequestDto {
    private String title;
    private String username; // 보완상 문제로 private
    private LocalDateTime createAt;
    private String contents;

    public PostRequestDto(Memo post) {
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.createAt = post.getCreatedAt();
        this.contents = post.getContents();
    }
}
