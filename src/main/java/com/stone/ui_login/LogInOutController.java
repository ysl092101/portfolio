package com.stone.ui_login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.dataservice_member.IMemberDAO;

@Controller
public class LogInOutController {

	@Autowired IMemberDAO memberDAO;

	// 로그인
	@GetMapping("/login")
	public String 로그인준비하다() {
		// 경로
		return "로그인";
	}

	// 로그인 → main or manager/main
	@RequestMapping("/login")
	public ModelAndView 로그인하다(String id, String pw, HttpSession session) {
		// 업무
		Object[] 번호와이름 = memberDAO.isIn(id, pw);

		// 아이디 미입력 시 message 전송
		if (id == "") {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("로그인");
			mv.addObject("message", "아이디를 입력해 주세요.");
			return mv;
		}

		// 비밀번호 미입력 시 message 전송
		if (pw == "") {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("로그인");
			mv.addObject("message", "비밀번호를 입력해 주세요.");
			return mv;
		}

		// 로그인 실패 시 message 전송
		if (번호와이름 == null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("로그인");
			mv.addObject("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return mv;
		}

		// 로그인 성공 시 회원no,name 전송
		session.setAttribute("no", 번호와이름[0]);
		session.setAttribute("name", 번호와이름[1]);
		session.setMaxInactiveInterval(60*30); // 30분(초단위)

		// 경로1
		if (id.equals("admin") == true) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("manager/main");
			return mv;
		}

		// 경로2
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/main");
		return mv;
	}

	// 로그아웃 → main
	@RequestMapping("/logout")
	public ModelAndView 로그아웃하다(HttpSession session) {
		// 업무
		if (session != null) session.invalidate();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/main");
		return mv;
	}
}