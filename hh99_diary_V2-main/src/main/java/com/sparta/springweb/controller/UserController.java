package com.sparta.springweb.controller;

import com.sparta.springweb.dto.SignupRequestDto;
import com.sparta.springweb.security.provider.UserDetailsImpl;
import com.sparta.springweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto, Model model) {
        if (userService.registerUser(requestDto).equals("")) {
            return "login";
        } else {
            model.addAttribute("errortext", userService.registerUser(requestDto));
            return "signup";
        }
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 로그인 에러 표시
    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    // 유저 로그인 체크
    @GetMapping("/api/userCheck")
    public String userCheck(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            return userDetails.getUser().getUsername();
        }
        return "";
    }
}