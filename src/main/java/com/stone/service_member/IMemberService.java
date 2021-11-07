package com.stone.service_member;

import com.stone.common_member.Member;

public interface IMemberService {

	Member process1(int no);

	Member process2(Member member, int no);
}