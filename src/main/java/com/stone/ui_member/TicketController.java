package com.stone.ui_member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.common_ticket.Ticket;
import com.stone.service_member.ITicketService;

@Controller
public class TicketController {

	@Autowired ITicketService ticketService;

	// 티켓예매
	@RequestMapping("/ticket")
	public ModelAndView 티켓예매하다(int adult, int teen, int kid, HttpSession session, int exhibition_no) {
		// 업무
		int member_no = (int)session.getAttribute("no");
		int price = ticketService.process1(adult, teen, kid, member_no, exhibition_no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("티켓예매");
		mv.addObject("price", price);
		return mv;
	}

	// 티켓목록
	@RequestMapping("/tickets")
	public ModelAndView 티켓목록출력하다(HttpSession session) {
		// 업무
		int member_no = (int)session.getAttribute("no");
		List<Ticket> tickets = ticketService.process2(member_no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("티켓목록");
		mv.addObject("tickets", tickets);
		return mv;
	}

	// 티켓상세
	@RequestMapping("/tickets/{no}")
	public ModelAndView 티켓상세출력하다(@PathVariable("no") int no) {
		// 업무
		Ticket ticket = ticketService.process3(no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("티켓상세");
		mv.addObject("ticket", ticket);
		return mv;
	}

	// 티켓취소
	@RequestMapping("/tickets/cancel")
	public ModelAndView 티켓취소하다(int no) {
		// 업무
		int price = ticketService.process4(no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("티켓취소");
		mv.addObject("price", price);
		return mv;
	}
}