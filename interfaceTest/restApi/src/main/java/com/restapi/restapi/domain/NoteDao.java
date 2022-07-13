package com.restapi.restapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.

public class NoteDao {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public String Id;

    @Column
    public String title;

    @Column
    public String contents;

    public NoteDao(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
public NoteDao(NoteRequestDto requestDto){
title = requestDto.getTitle();
contents = requestDto.getContents();
}
    }
