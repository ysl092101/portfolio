package com.stone.dataservice_ticket;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ITicketMapper {

	// 회원티켓상세 - state변경
	@Update("UPDATE ticket SET state=1 WHERE no=#{no}")
	void update(int no);

	// 전시삭제
	@Select("SELECT count(*) as cnt FROM ticket WHERE exhibition_no=#{no}") // count(*)가 1이면(티켓이 존재하면) 0 리턴, 아니면 1 리턴
	boolean isIn(int no);

	// 티켓취소
	@Delete("DELETE FROM ticket WHERE no=#{no}")
	void delete(int no);
}