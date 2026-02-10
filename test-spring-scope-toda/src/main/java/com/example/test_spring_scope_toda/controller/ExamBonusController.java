package com.example.test_spring_scope_toda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test_spring_scope_toda.domain.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ex03")
public class ExamBonusController {

    @Autowired
    private HttpSession session;

    @RequestMapping("")
    public String index() {
        return "exam-bonus-input";
    }

    @RequestMapping("/input")
    public String input(String email, String password, Model model) {
        if (email.equals("yamada@sample.com") && password.equals("yamayama")) {
            User user = new User();
            user.setAge(18);
            user.setEmail("yamada@sample.com");
            user.setName("山田太郎");
            session.setAttribute("user", user);
            return "exam-bonus-result";
        } else {
            model.addAttribute("str", "ログインに失敗しました");
            return "exam-bonus-input";
        }
    }
}
