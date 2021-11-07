package com.stone.dataservice_ticket;

import java.util.List;

import com.stone.common_ticket.Ticket;

public interface ITicketDAO {

	// 관리자
	List<Ticket> listView(int no); // 회원티켓목록

	Ticket findByNo(int no); // 회원티켓상세

	void update(int no); // 회원티켓상세 - state변경

	boolean isIn(int no); // 전시삭제

	// 회원
	void save(int adult, int teen, int kid, int price, int member_no, int exhibition_no); // 티켓예매

	// List<Ticket> listView(int no); // 티켓목록

	// Ticket findByNo(int no); // 티켓상세

	void delete(int no); // 티켓취소
}