package com.stone.dataservice_place;

import java.util.List;

import com.stone.common_place.Place;

public interface IPlaceDAO {

	// 관리자
	void save(Place place); // 장소등록

	List<Place> listView(); // 장소목록

	List<Place> findByName(String name); // 장소목록 - name검색, (전시등록)장소검색 - name검색

	Place findByPlace(String name); // (전시상세)장소상세

	void delete(int no); // 장소삭제

	// 회원
	// Place findByPlace(String place); // (전시상세)장소상세
}