package com.sparta.week03.ControllerPackage;

import com.sparta.week03.domain.*;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만듦
@RestController // 해당 어노테이션을 통해 아래에 생성자를 선언해줄 필요 없이, 스프링이 처리함 (파라미터는 위 어노테이션을 통해 생성)
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos") // 생성
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) { // 생성할 메모의 데이터를 받기위해 Dto를 받아줌 , @RequestBody를
        Memo memo = new Memo(requestDto); // requestDto의 데이터를 파라미터로 주어 Memo로 삽입  // 통해 Body에 넣어줌
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos") // 조회
    public List<ReadRequestDto> getMemos() {
        List<ReadRequestDto> result = new ArrayList<ReadRequestDto>();
        for (Memo memo : memoRepository.findAllByOrderByCreatedAtDesc())
            result.add(new ReadRequestDto(memo));
        return result;
    }


    @GetMapping("/api/memos/{id}") // 게시글 조회
    public PostRequestDto getcontents(@PathVariable Long id) {
        return memoService.getContents(id);
    }


    @DeleteMapping("/api/memos/{id}") // 삭제   변수는 {}안에 넣어줌
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id); // id의 위치를 모르기 때문에 @PathVariable을 사용하여 경로에 있는 변수{}를 가져옴

        return id;
    }

    @PutMapping("/api/memos/{id}") // 수정
    public Long putMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }
}