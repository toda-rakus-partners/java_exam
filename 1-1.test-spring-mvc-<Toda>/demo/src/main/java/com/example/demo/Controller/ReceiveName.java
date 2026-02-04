package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.ReceiveNameForm;

@Controller
@RequestMapping("/ex03")
public class ReceiveName {

    @ModelAttribute
    public ReceiveNameForm setUpForm() {
        return new ReceiveNameForm();
    }

    @RequestMapping("")
    public String index() {
        return "name-form";
    }

    // 問3で利用するメソッド
    @RequestMapping("/create")
    public String create(String name) {
        System.out.println("入力された値は" + name + "です。");

        return "finished";
    }

    // 問4で利用するメソッド
    @RequestMapping("/createForm")
    public String createForm (ReceiveNameForm receiveNameForm) {
        System.out.println("入力された値は" + receiveNameForm.getName() + "です。");

        return "finished";
    }
}
