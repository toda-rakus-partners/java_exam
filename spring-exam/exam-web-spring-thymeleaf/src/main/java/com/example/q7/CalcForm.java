package com.example.q7;

import jakarta.validation.constraints.NotBlank;


public class CalcForm {
	
	@NotBlank(message = "左のテキストボックスには数値を入力してください。")
	private String left;
	@NotBlank(message = "右のテキストボックスには数値を入力してください。")
	private String right;
	
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
}
