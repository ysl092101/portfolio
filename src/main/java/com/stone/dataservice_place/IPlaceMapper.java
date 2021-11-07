package com.stone.dataservice_place;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.stone.common_place.Place;

@Mapper
public interface IPlaceMapper {

	// 장소등록
	@Insert("INSERT INTO place(name,post,address,tel,page) VALUES(#{name},#{post},#{address},#{tel},#{page})")
	void save(Place place);

	// 장소목록
	@Select("SELECT * FROM place ORDER BY name")
	List<Place> listView();

	// (전시상세)장소상세
	@Select("SELECT * FROM place WHERE name=#{name}")
	Place findByPlace(String name);

	// 장소삭제
	@Delete("DELETE FROM place WHERE no=#{no}")
	void delete(int no);
}