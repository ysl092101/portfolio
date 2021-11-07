package com.stone.ui_login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stone.common_member.Member;
import com.stone.dataservice_member.IMemberDAO;

@Controller
public class JoinController {

	@Autowired IMemberDAO memberDAO;

	// 회원가입
	@GetMapping("/join")
	public String 회원가입준비하다() {
		// 경로
		return "회원가입";
	}

	// 회원가입완료
	@RequestMapping("/join")
	public ModelAndView 회원가입하다(@ModelAttribute Member member) {
		// 업무
		memberDAO.save(member);
	
		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("회원가입완료");
		mv.addObject("id", member.getId());
		return mv;
	}

	// 회원가입아이디
	@GetMapping("/id")
	public String 회원가입아이디준비하다() {
		// 경로
		return "회원가입아이디";
	}

	// 회원가입아이디
	@RequestMapping(value="/id", method={RequestMethod.POST})
	@ResponseBody
	public boolean 회원가입아이디중복검사하다(@RequestParam("id") String id) {
		return memberDAO.isIn(id); // true=사용가능, false=이미존재
	}
}