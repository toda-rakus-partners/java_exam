package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

    @RequestMapping("/show-company-introduction")
    public String showCompanyIntroduction() {
        return "exam-02";
    }

    @RequestMapping("")
    public String showCompanyIntroduction2() {
        return "redirect:/exam02/show-company-introduction";
    }
}
