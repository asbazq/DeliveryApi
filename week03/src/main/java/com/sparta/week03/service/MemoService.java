package com.sparta.week03.service;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final이 존재하면 생성자에 넣음
@Service
public class MemoService {

    private final MemoRepository memoRepository; // find를 실행시키기 위해 메소드로 저장소 선언
                                                // Meomrepository를 사용할 때 받기위해 final
    @Transactional // 업데이트 시 DB에 반영
    public Long update(Long id, MemoRequestDto requestDto) { // 반환타입 메소드이름(파라미터)
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (!memo.getPassword().equals(requestDto.getPassword())) throw new IllegalArgumentException("X");
        memo.update(requestDto); //requestDto를 파라미터로 자지고 실행 , memo class에 update 생성
        return memo.getId(); // 실행 값(Id)
    }

    @Transactional
    public PostRequestDto getContents(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new PostRequestDto(memo);
    }

    @Transactional
    public Long Delete(Long id, MemoRequestDto requestDto) { // 삭제
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (!memo.getPassword().equals(requestDto.getPassword())) throw new IllegalArgumentException("X");
        memoRepository.delete(memo);
        return memo.getId();
    }
}