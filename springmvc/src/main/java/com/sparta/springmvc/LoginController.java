package com.sparta.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String longin () {
        return "redirect:/login-form.html";
    }

    @PostMapping("/login") // 동적
    public String loginresult(@RequestParam String id, @RequestParam String password, Model model) { // Model 정보를 넘겨주기 위한 Model
        if (id.equals(password)) model.addAttribute("loginId",id);  // spring에서 알아서 Model정보를 넣어서 채움
        return "login-result"; // template engine에 전달
    }
}
