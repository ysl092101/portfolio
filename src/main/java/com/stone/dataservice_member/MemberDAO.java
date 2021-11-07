package com.stone.dataservice_member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stone.common_member.Member;
import com.stone.dataservice_member.MemberDAO;
import com.stone.util.ConnectionUtil;
import com.stone.util.SecurityUtil;

@Repository
public class MemberDAO implements IMemberDAO {

	@Autowired IMemberMapper memberMapper;

	Connection DB연결관리자 = null;
	PreparedStatement 명령자 = null;
	ResultSet 수집결과 = null;

	SecurityUtil secUtil = new SecurityUtil();

	@Transactional
	public boolean isIn(String id) {
		return memberMapper.isIn(id);
	}

	// 회원가입
	@Override
	@Transactional
	public void save(Member member) {
		String pw = secUtil.encrypt(member.getPw());

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("INSERT INTO member(id,pw,name,phone,email) VALUES(?,?,?,?,?)");
			명령자.setString(1, member.getId());
			명령자.setString(2, pw);
			명령자.setString(3, member.getName());
			명령자.setString(4, member.getPhone());
			명령자.setString(5, member.getEmail());

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

	// 로그인
	@Override
	@Transactional
	public Object[] isIn(String id, String pw) {
		Object[] 번호와이름 = null;
		String password = secUtil.encrypt(pw);

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT no,name FROM member WHERE id=? and pw=?");
			명령자.setString(1, id);
			명령자.setString(2, password);

			수집결과 = 명령자.executeQuery();

			if (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 이름 = 수집결과.getString("name");

				번호와이름 = new Object[2];
				번호와이름[0] = 번호;
				번호와이름[1] = 이름;
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

		return 번호와이름;
	}

	@Transactional
	public Member findByNo(int no) {
		return memberMapper.findByNo(no);
	}

	@Transactional
	public List<Member> listView() {
		return memberMapper.listView();
	}

	// 회원목록 - id검색
	@Override
	@Transactional
	public List<Member> findById(String id) {
		ArrayList<Member> 찾은회원리스트 = new ArrayList<Member>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM member WHERE no<>1 and id like ?");
			명령자.setString(1, "%"+id+"%");

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 아이디 = 수집결과.getString("id");
				String 비밀번호 = 수집결과.getString("pw");
				String 이름 = 수집결과.getString("name");
				String 휴대전화 = 수집결과.getString("phone");
				String 이메일 = 수집결과.getString("email");

				Member 찾은회원 = new Member();

				찾은회원.setNo(번호);
				찾은회원.setId(아이디);
				찾은회원.setPw(비밀번호);
				찾은회원.setName(이름);
				찾은회원.setPhone(휴대전화);
				찾은회원.setEmail(이메일);

				찾은회원리스트.add(찾은회원);
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

		return 찾은회원리스트;
	}

	// 개인정보수정
	@Override
	@Transactional
	public void update(Member member, int no) {
		String pw = secUtil.encrypt(member.getPw());

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("UPDATE member SET pw=?,phone=?,email=? WHERE no=?");
			명령자.setString(1, pw);
			명령자.setString(2, member.getPhone());
			명령자.setString(3, member.getEmail());
			명령자.setInt(4, no);

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
}