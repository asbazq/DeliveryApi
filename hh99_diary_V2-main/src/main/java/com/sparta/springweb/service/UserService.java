package com.sparta.springweb.service;

import com.sparta.springweb.dto.SignupRequestDto;
import com.sparta.springweb.model.User;
import com.sparta.springweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public String registerUser(SignupRequestDto requestDto) {
        String error = "";
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String password2 = requestDto.getPassword2();

        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);

        String pattern = "^[a-zA-Z0-9]*$";

        if (found.isPresent()) {
            return "중복된 닉네임이 존재합니다";
        }

        if (username.length() < 3) {
            return "닉네임을 3자 이상 입력하세요";
        } else if (!Pattern.matches(pattern, username)) {
            return "알파벳 대소문자와 숫자로만 입력하세요";
        } else if (!password.equals(password2)) {
            return "비밀번호가 일치하지 않습니다";
        } else if (password.length() < 4) {
            return "비밀번호를 4자 이상 입력하세요";
        } else if (password.contains(username)) {
            return "비밀번호는 닉네임과 달라야 합니다";
        }

        // 패스워드 암호화
        password = passwordEncoder.encode(password);
        requestDto.setPassword(password);

        User user = new User(username, password);
        userRepository.save(user);
        return error;
    }
}