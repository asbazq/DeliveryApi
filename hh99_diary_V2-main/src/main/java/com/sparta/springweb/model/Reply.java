package com.sparta.springweb.model;

import com.sparta.springweb.dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Reply extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long postid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String reply;

    @Column(nullable = false)
    private Long userId;

    public Reply(ReplyRequestDto requestDto, Long userId) {
        this.postid = requestDto.getPostid();
        this.reply = requestDto.getReply();
        this.username = requestDto.getUsername();
        this.userId = userId;
    }
    public Reply(ReplyRequestDto requestDto, Long userId, String reply) {
        this.postid = requestDto.getPostid();
        this.reply = reply;
        this.username = requestDto.getUsername();
        this.userId = userId;
    }

    public void update(ReplyRequestDto requestDto) {
        this.reply = requestDto.getReply();
    }
}

