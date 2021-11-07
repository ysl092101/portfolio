package com.stone.service_member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stone.common_member.Member;
import com.stone.dataservice_member.IMemberDAO;

@Service
public class MemberService implements IMemberService {

	@Autowired IMemberDAO memberDAO;

	@Override
	@Transactional
	public Member process1(int no) {
		return memberDAO.findByNo(no);
	}

	@Override
	@Transactional
	public Member process2(Member member, int no) {
		memberDAO.update(member, no);
		return memberDAO.findByNo(no);
	}
}