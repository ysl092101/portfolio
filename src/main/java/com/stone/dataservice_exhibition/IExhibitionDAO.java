package com.stone.dataservice_exhibition;

import java.util.List;

import com.stone.common_exhibition.Exhibition;

public interface IExhibitionDAO {

	// 관리자
	void save(Exhibition exhibition); // 전시등록

	List<Exhibition> listView(); // 전시목록

	List<Exhibition> findByTitle(String title); // 전시목록 - title검색

	Exhibition findByNo(int no); // 전시상세

	List<Exhibition> listView2(); // 지난전시목록

	List<Exhibition> findByTitle2(String title); // 지난전시목록 - title검색

	void delete(int no); // 전시삭제

	// 회원
	List<Exhibition> newListView(); // main1

	List<Exhibition> topListView(); // main2

	List<Exhibition> closeListView(); // main3

	List<Exhibition> listView(Integer order); // 전시목록

	List<Exhibition> findByPlaceNo(int no); // 장소목록
}