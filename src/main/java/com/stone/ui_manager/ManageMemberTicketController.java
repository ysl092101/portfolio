package com.stone.ui_manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.common_member.Member;
import com.stone.common_ticket.Ticket;
import com.stone.dataservice_member.IMemberDAO;
import com.stone.dataservice_ticket.ITicketDAO;

@Controller
public class ManageMemberTicketController {

	@Autowired IMemberDAO memberDAO;
	@Autowired ITicketDAO ticketDAO;

	// 관리자정보
	@GetMapping("/manager/myinfo")
	public ModelAndView 관리자정보출력하다() {
		// 업무
		Member member = memberDAO.findByNo(1);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/member/관리자정보");
		mv.addObject("member", member);
		return mv;
	}

	// 회원목록
	@GetMapping("/manager/members")
	public ModelAndView 회원목록출력하다() {
		// 업무
		List<Member> members = memberDAO.listView();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/member/회원목록");
		mv.addObject("members", members);
		return mv;
	}

	// 회원목록 - id검색
	@RequestMapping("/manager/members/search")
	public ModelAndView 회원목록검색하다(String srchId) {
		// 업무
		List<Member> members = memberDAO.findById(srchId);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/member/회원목록");
		mv.addObject("members", members);
		return mv;
	}

	// 회원티켓목록
	@RequestMapping("/manager/members/{no}")
	public ModelAndView 회원티켓목록출력하다(@PathVariable("no") int no) {
		// 업무
		List<Ticket> tickets = ticketDAO.listView(no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/member/회원티켓목록");
		mv.addObject("tickets", tickets);
		return mv;
	}

	// 회원티켓상세
	@RequestMapping("/manager/tickets/{no}")
	public ModelAndView 회원티켓상세출력하다(@PathVariable("no") int no) {
		// 업무
		Ticket ticket = ticketDAO.findByNo(no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/member/회원티켓상세");
		mv.addObject("ticket", ticket);
		return mv;
	}

	// 회원티켓상세 - state변경
	@RequestMapping("/manager/tickets/{no}/update")
	public ModelAndView 회원티켓사용하다(@PathVariable("no") int no) {
		// 업무
		ticketDAO.update(no);
		Ticket ticket = ticketDAO.findByNo(no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/member/회원티켓상세");
		mv.addObject("ticket", ticket);
		return mv;
	}
}