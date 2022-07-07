package com.sparta.week03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long password;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    public Memo(String username, String contents, String title, Long password) {
        this.username = username;
        this.contents = contents;
        this.title = title;
        this.password = password;
    }

    public Memo(MemoRequestDto requestDto) { // MemoRequestDto를 Memo형식으로 변환
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }

    public void update(MemoRequestDto requestDto) { // 값을 전달 받기 위해 MemoService에서  requestDto를 받는다.
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }

}