package com.sparta.week01.service;

import com.sparta.week01.domain.Course;
import com.sparta.week01.domain.CourseRepository;
import com.sparta.week01.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // 생성자를 자동으로 생성 - 필요한 멤버 변수를 fInal로 선언하면 아무 method에서 사용 가능
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final CourseRepository courseRepository;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
//    public CourseService(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, CourseRequestDto requestDto) { // 어플리케이션의 변경에 따라 변경
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        course1.update(requestDto);
        return course1.getId();
    }
}