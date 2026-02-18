package com.example.test_spring_thymeleaf_toda.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test_spring_thymeleaf_toda.domain.Member;
import com.example.test_spring_thymeleaf_toda.form.memberForm;

@Controller
@RequestMapping("/test")
public class ExamThymeleafController {

    @RequestMapping("")
    public String index() {
        return "ex-thymeleaf-input";
    }

    @RequestMapping("/input")
    public String input(memberForm form, Model model) {
        Member member = new Member();
        member.setName(form.getName());
        member.setAge(form.getAge());
        member.setHobbyList(form.getHobbyList());
        model.addAttribute("data", member);
        return "ex-thymeleaf-result";
    }
}
