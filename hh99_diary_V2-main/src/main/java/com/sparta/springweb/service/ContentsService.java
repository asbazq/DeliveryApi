package com.sparta.springweb.service;

import com.sparta.springweb.dto.ContentsRequestDto;
import com.sparta.springweb.model.Contents;
import com.sparta.springweb.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ContentsService {

    private final com.sparta.springweb.repository.ContentsRepository ContentsRepository;

    @Transactional
    public Contents createContents(ContentsRequestDto requestDto, String username) {
        String contentsCheck = requestDto.getContents();
        String titleCheck = requestDto.getTitle();
        if (contentsCheck.contains("script")||contentsCheck.contains("<")||contentsCheck.contains(">")){
            Contents contents = new Contents(requestDto,username,"잘못된 입력입니다(XSS 공격금지)");
            ContentsRepository.save(contents);
            return contents;
        }
        if (titleCheck.contains("script")||titleCheck.contains("<")||titleCheck.contains(">")) {
            Contents contents = new Contents("잘못된 입력입니다(XSS 공격금지)", username, "잘못된 입력입니다(XSS 공격금지)");
            ContentsRepository.save(contents);
            return contents;
        }
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Contents contents = new Contents(requestDto, username);
        ContentsRepository.save(contents);
        return contents;
    }

    @Transactional
    public Long update(Long id, ContentsRequestDto requestDto) {
        Contents Contents = ContentsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("일지가 존재하지 않습니다.")
        );
        Contents.update(requestDto);
        return Contents.getId();
    }
}