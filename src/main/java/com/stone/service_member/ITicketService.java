package com.stone.service_member;

import java.util.List;

import com.stone.common_ticket.Ticket;

public interface ITicketService {

	int process1(int adult, int teen, int kid, int member_no, int exhibition_no);

	List<Ticket> process2(int member_no);

	Ticket process3(int no);

	int process4(int no);
}