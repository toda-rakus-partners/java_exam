package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")
public class Exam01Controller {


    @RequestMapping("/show-self-introduction")
    public String showSelfIntroduction() {
        return "exam-01";
    }
}
