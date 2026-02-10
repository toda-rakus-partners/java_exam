package com.example.test_spring_scope_toda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.test_spring_scope_toda.form.ex01Form;

@Controller
@RequestMapping("/ex01")
public class Exam01Controller {

    @RequestMapping("")
    public String index () {
        return "exam01";
    }

    @RequestMapping("/input")
    public String input (ex01Form form, Model model) {
        if (form.getEmail().equals("yamada@sample.com") && form.getPassword().equals("yamayama")) {
            model.addAttribute("str", "成功");
        } else {
            model.addAttribute("str", "失敗");
        }
        return "login";
    }
}
