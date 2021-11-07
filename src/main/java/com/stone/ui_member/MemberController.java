package com.stone.ui_member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.common_member.Member;
import com.stone.service_member.IMemberService;

@Controller
public class MemberController {

	@Autowired(required=false) IMemberService memberService;

	// 개인정보
	@RequestMapping("/member/{no}")
	public ModelAndView 개인정보출력하다(@PathVariable("no") int no) {
		// 업무
		Member member = memberService.process1(no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("개인정보");
		mv.addObject("member", member);
		return mv;
	}

	// 개인정보수정
	@RequestMapping("/member/{no}/update")
	public ModelAndView 개인정보수정준비하다(@PathVariable("no") int no) {
		// 업무
		Member member = memberService.process1(no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("개인정보수정");
		mv.addObject("member", member);
		return mv;
	}

	// 개인정보수정 → 개인정보
	@RequestMapping("/member/{no}/updated")
	public ModelAndView 개인정보수정하다(@ModelAttribute Member member, @PathVariable("no") int no) {
		// 업무
		Member memberr = memberService.process2(member, no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("개인정보");
		mv.addObject("member", memberr);
		return mv;
	}
}