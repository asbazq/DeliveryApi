package com.restapi.restapi.ControllerPackage;

import com.restapi.restapi.domain.NoteDao;
import com.restapi.restapi.domain.NoteRepository;
import com.restapi.restapi.domain.NoteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만듦
@RestController // 해당 어노테이션을 통해 아래에 생성자를 선언해줄 필요 없이, 스프링이 처리함 (파라미터는 위 어노테이션을 통해 생성)
public class Router {

private final NoteRepository noteRepository;

@PostMapping("/api/note")
    public NoteDao WriteNote(@RequestBody NoteRequestDto requestDto) {
    NoteDao noteDao = new NoteDao(requestDto);
    return noteRepository.save(noteDao);
}

@GetMapping("api/note")
    public List<NoteDao> ReadNote() {
    return noteRepository.findAllByOrderByTitleDesc();
}

@DeleteMapping("api/note/{id}")
    public NoteDao Deletenote(@PathVariable String id) {
    NoteDao noteDao = noteRepository.findById(id).orElseThrow(
        () ->new IllegalArgumentException("id_X")
);
    noteRepository.delete(noteDao);
    return noteDao;
}
}
