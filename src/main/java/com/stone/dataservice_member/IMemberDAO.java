package com.stone.dataservice_member;

import java.util.List;

import com.stone.common_member.Member;

public interface IMemberDAO {

	boolean isIn(String id); // 회원가입아이디

	void save(Member member); // 회원가입

	Object[] isIn(String id, String pw); // 로그인

	// 관리자
	Member findByNo(int no); // 관리자정보

	List<Member> listView(); // 회원목록

	List<Member> findById(String id); // 회원목록 - id검색

	// 회원
	// Member findByNo(int no); // 개인정보

	void update(Member member, int no); // 개인정보수정
}