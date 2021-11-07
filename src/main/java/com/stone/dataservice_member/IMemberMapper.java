package com.stone.dataservice_member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.stone.common_member.Member;

@Mapper
public interface IMemberMapper {

	// 회원가입아이디
	@Select("SELECT if(count(*)=1,0,1) FROM member WHERE id=#{id}") // count(*)가 1이면(id가 존재하면) 0 리턴, 아니면 1 리턴
	boolean isIn(String id);

	// 관리자정보, 개인정보
	@Select("SELECT * FROM member WHERE no=#{no}")
	Member findByNo(int no);

	// 회원목록
	@Select("SELECT * FROM member WHERE no<>1 ORDER BY no")
	List<Member> listView();
}