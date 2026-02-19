package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberRepository repository;

	@RequestMapping("")
	public String index() {

		// 問5の解答コード

		List<Member> memberList = repository.findAll(); 
		for (Member list : memberList) {
			System.out.println(list);
		}
		System.out.println(repository.load(2));


		// 問6の解答コード

		Member member = new Member();
		member.setName("土田聖");
		member.setAge(22);
		member.setDepId(1);
		repository.save(member);

		Member member2 = new Member();
		member2.setId(2);
		member2.setName("シロー");
		member2.setAge(32);
		member2.setDepId(2);
		repository.save(member2);
		return "member";
	}
}
