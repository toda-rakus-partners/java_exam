package com.example.q7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Q7. パラメータ<code>left</code>と<code>right</code>が数値でない場合に、
 * 入力画面にエラーメッセージを表示させるように修正しなさい。
 *
 * (エラーメッセージの例)
 * <pre>
 * ・左のテキストボックスには数値を入力してください。
 * ・右のテキストボックスには数値を入力してください。
 * </pre>
 */
@Controller
public class CalcController {
	
	@ModelAttribute
	public CalcForm setUpForm(){
		return new CalcForm();
	}
	
	@RequestMapping(value="/q7")
	public String gotoq7(Model model){
		return "7/calc";
	}
	
	@RequestMapping(value="/add")
	public String create(@Validated CalcForm calcForm, BindingResult result,
						 RedirectAttributes redirectAttributes,
						 Model model){
				
		if (result.hasErrors()) {
			return "7/calc";
		}
						
		Integer calcresult = Integer.parseInt(calcForm.getRight()) + Integer.parseInt(calcForm.getLeft());	
		model.addAttribute("result",calcresult);
		
		return "7/calc";
	}
}
