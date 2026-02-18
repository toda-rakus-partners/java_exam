package com.example.test_spring_thymeleaf_toda.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex-bonus")
public class ExamBonusController {
    @RequestMapping("")
    public String index(Model model) {
    List<String> kingList = new ArrayList<>();
    kingList.add("平野");
    kingList.add("永瀬");
    kingList.add("高橋");

    List<String> princeList = new ArrayList<>();
    princeList.add("岸");
    princeList.add("岩橋");
    princeList.add("神宮寺");

    List<List<String>> groupList = new ArrayList<>();
    groupList.add(kingList);
    groupList.add(princeList);

    model.addAttribute("groupList", groupList);
    return "ex-bonus";
    }
}
