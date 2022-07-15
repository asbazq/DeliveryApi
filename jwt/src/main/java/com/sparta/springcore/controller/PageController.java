package com.sparta.springcore.controller;

import com.sparta.springcore.security.FormLoginSuccessHandler;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/detail.html")
    public String detail(Model model, @AuthenticationPrincipal FormLoginSuccessHandler.UserDetailsImpl userDetails) {
        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
        }
        return "detail";
    }
}