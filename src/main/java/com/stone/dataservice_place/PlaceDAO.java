package com.stone.dataservice_place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stone.common_place.Place;
import com.stone.util.ConnectionUtil;

@Repository
public class PlaceDAO implements IPlaceDAO {

	@Autowired IPlaceMapper placeMapper;

	Connection DB연결관리자 = null;
	PreparedStatement 명령자 = null;
	ResultSet 수집결과 = null;

	@Transactional
	public void save(Place place) {
		placeMapper.save(place);
	}

	@Transactional
	public List<Place> listView() {
		return placeMapper.listView();
	}

	// 장소목록 - name검색, (전시등록)장소검색 - name검색
	@Override
	@Transactional
	public List<Place> findByName(String name) {
		ArrayList<Place> 찾은장소리스트 = new ArrayList<Place>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM place WHERE name like ? ORDER BY name");
			명령자.setString(1, "%"+name+"%");

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 이름 = 수집결과.getString("name");
				String 우편번호 = 수집결과.getString("post");
				String 주소 = 수집결과.getString("address");
				String 전화번호 = 수집결과.getString("tel");
				String 홈페이지 = 수집결과.getString("page");

				Place 찾은장소 = new Place();

				찾은장소.setNo(번호);
				찾은장소.setName(이름);
				찾은장소.setPost(우편번호);
				찾은장소.setAddress(주소);
				찾은장소.setTel(전화번호);
				찾은장소.setPage(홈페이지);

				찾은장소리스트.add(찾은장소);
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

		return 찾은장소리스트;
	}

	@Transactional
	public Place findByPlace(String name) {
		return placeMapper.findByPlace(name);
	}

	@Transactional
	public void delete(int no) {
		placeMapper.delete(no);
	}
}