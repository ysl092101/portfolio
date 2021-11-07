package com.stone.service_member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stone.common_exhibition.Exhibition;
import com.stone.common_ticket.Ticket;
import com.stone.dataservice_exhibition.IExhibitionDAO;
import com.stone.dataservice_ticket.ITicketDAO;

@Service
public class TicketService implements ITicketService {

	@Autowired IExhibitionDAO exhibitionDAO;
	@Autowired ITicketDAO ticketDAO;

	@Override
	@Transactional
	public int process1(int adult, int teen, int kid, int member_no, int exhibition_no) {
		Exhibition exhibition = exhibitionDAO.findByNo(exhibition_no);
		int a = exhibition.getAdultfee();
		int b = exhibition.getTeenfee();
		int c = exhibition.getKidfee();
		int price = adult*a + teen*b + kid*c;
		ticketDAO.save(adult, teen, kid, price, member_no, exhibition_no);
		return price;
	}

	@Override
	@Transactional
	public List<Ticket> process2(int member_no) {
		return ticketDAO.listView(member_no);
	}

	@Override
	@Transactional
	public Ticket process3(int no) {
		return ticketDAO.findByNo(no);
	}

	@Override
	@Transactional
	public int process4(int no) {
		Ticket ticket = ticketDAO.findByNo(no);
		int price = ticket.getPrice();
		ticketDAO.delete(no);
		return price;
	}
}