package com.stone.dataservice_ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stone.common_exhibition.Exhibition;
import com.stone.common_member.Member;
import com.stone.common_ticket.Ticket;
import com.stone.dataservice_exhibition.IExhibitionDAO;
import com.stone.dataservice_member.IMemberDAO;
import com.stone.util.ConnectionUtil;

@Repository
public class TicketDAO implements ITicketDAO {

	@Autowired ITicketMapper ticketMapper;
	@Autowired IExhibitionDAO exhibitionDAO;
	@Autowired IMemberDAO memberDAO;

	Connection DB연결관리자 = null;
	PreparedStatement 명령자 = null;
	ResultSet 수집결과 = null;

	// 회원티켓목록, 티켓목록
	@Override
	@Transactional
	public List<Ticket> listView(int no) {
		ArrayList<Ticket> 티켓리스트 = new ArrayList<Ticket>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM ticket WHERE member_no=? ORDER BY no desc");
			명령자.setInt(1, no);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				Date 예매한날 = 수집결과.getDate("wdate");
				// 전시정보
				int 전시번호 = 수집결과.getInt("exhibition_no");
				Exhibition 예매된전시 = exhibitionDAO.findByNo(전시번호);

				Ticket 수집된티켓 = new Ticket();

				수집된티켓.setNo(번호);
				수집된티켓.setWdate(예매한날);
				수집된티켓.setExhibition(예매된전시);

				티켓리스트.add(수집된티켓);
			}

			수집결과.close();
			명령자.close();
			DB연결관리자.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (!명령자.isClosed()) 명령자.close();
				if (!DB연결관리자.isClosed()) DB연결관리자.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return 티켓리스트;
	}

	// 회원티켓상세, 티켓상세
	@Override
	@Transactional
	public Ticket findByNo(int no) {
		Ticket 찾은티켓 = null;

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM ticket WHERE no=?");
			명령자.setInt(1, no);

			수집결과 = 명령자.executeQuery();

			if (수집결과.next()) {
				int 성인 = 수집결과.getInt("adult");
				int 청소년 = 수집결과.getInt("teen");
				int 어린이 = 수집결과.getInt("kid");
				int 가격 = 수집결과.getInt("price");
				Date 예매한날 = 수집결과.getDate("wdate");
				int 상태 = 수집결과.getInt("state");
				// 회원정보
				int 회원번호 = 수집결과.getInt("member_no");
				Member 예매한회원 = memberDAO.findByNo(회원번호);
				// 전시정보
				int 전시번호 = 수집결과.getInt("exhibition_no");
				Exhibition 예매된전시 = exhibitionDAO.findByNo(전시번호);

				찾은티켓 = new Ticket();

				찾은티켓.setNo(no);
				찾은티켓.setAdult(성인);
				찾은티켓.setTeen(청소년);
				찾은티켓.setKid(어린이);
				찾은티켓.setPrice(가격);
				찾은티켓.setWdate(예매한날);
				찾은티켓.setState(상태);
				찾은티켓.setMember(예매한회원);
				찾은티켓.setExhibition(예매된전시);
			}

			수집결과.close();
			명령자.close();
			DB연결관리자.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (!명령자.isClosed()) 명령자.close();
				if (!DB연결관리자.isClosed()) DB연결관리자.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return 찾은티켓;
	}

	@Transactional
	public void update(int no) {
		ticketMapper.update(no);
	}

	@Transactional
	public boolean isIn(int no) {
		return ticketMapper.isIn(no);
	}

	// 티켓예매
	@Override
	@Transactional
	public void save(int adult, int teen, int kid, int price, int member_no, int exhibition_no) {
		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("INSERT INTO ticket(adult,teen,kid,price,member_no,exhibition_no) VALUES(?,?,?,?,?,?)");
			명령자.setInt(1, adult);
			명령자.setInt(2, teen);
			명령자.setInt(3, kid);
			명령자.setInt(4, price);
			명령자.setInt(5, member_no);
			명령자.setInt(6, exhibition_no);

			명령자.executeUpdate();

			명령자.close();
			DB연결관리자.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (!명령자.isClosed()) 명령자.close();
				if (!DB연결관리자.isClosed()) DB연결관리자.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Transactional
	public void delete(int no) {
		ticketMapper.delete(no);
	}
}