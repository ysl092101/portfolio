package com.stone.dataservice_exhibition;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.stone.common_exhibition.Exhibition;

@Mapper
public interface IExhibitionMapper {

	// 전시등록
	@Insert("INSERT INTO exhibition(title,place,hall,startday,endday,age,adultfee,teenfee,kidfee,poster) "+
			"VALUES(#{title},#{place},#{hall},#{startday},#{endday},#{age},#{adultfee},#{teenfee},#{kidfee},#{poster})")
	void save(Exhibition exhibition);

	// 전시상세
	@Select("SELECT * FROM exhibition WHERE no=#{no}")
	Exhibition findByNo(int no);

	// 전시삭제
	@Delete("DELETE FROM exhibition WHERE no=#{no}")
	void delete(int no);
}