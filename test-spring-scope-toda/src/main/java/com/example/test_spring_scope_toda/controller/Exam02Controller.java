package com.example.test_spring_scope_toda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ex02")
public class Exam02Controller {

    @Autowired
    private HttpSession session;

    @RequestMapping("")
    public String index () {
        return "exam02";
    }

    @RequestMapping("/input")
    public String sum (int num1, int num2) {
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("total", num1 + num2);
        return "exam02-result";
    }

    @RequestMapping("/toPage")
    public String toPage() {
        return "exam02-result2";
    }
}
