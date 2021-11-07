package com.stone.dataservice_exhibition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stone.common_exhibition.Exhibition;
import com.stone.util.ConnectionUtil;

@Repository
public class ExhibitionDAO implements IExhibitionDAO {

	@Autowired IExhibitionMapper exhibitionMapper;

	Connection DB연결관리자 = null;
	PreparedStatement 명령자 = null;
	ResultSet 수집결과 = null;

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);

	@Transactional
	public void save(Exhibition exhibition) {
		exhibitionMapper.save(exhibition);
	}

	// 전시목록
	@Override
	@Transactional
	public List<Exhibition> listView() {
		ArrayList<Exhibition> 전시리스트 = new ArrayList<Exhibition>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM exhibition WHERE endday>=? ORDER BY no desc");
			명령자.setString(1, today);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 제목 = 수집결과.getString("title");
				String 장소 = 수집결과.getString("place");
				String 시작날 = 수집결과.getString("startday");
				String 마지막날 = 수집결과.getString("endday");

				Exhibition 수집된전시 = new Exhibition();

				수집된전시.setNo(번호);
				수집된전시.setTitle(제목);
				수집된전시.setPlace(장소);
				수집된전시.setStartday(시작날);
				수집된전시.setEndday(마지막날);

				전시리스트.add(수집된전시);
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

		return 전시리스트;
	}

	// 전시목록 - title검색
	@Override
	@Transactional
	public List<Exhibition> findByTitle(String title) {
		ArrayList<Exhibition> 찾은전시리스트 = new ArrayList<Exhibition>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM exhibition WHERE title like ? and endday>=? ORDER BY no desc");
			명령자.setString(1, "%"+title+"%");
			명령자.setString(2, today);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 제목 = 수집결과.getString("title");
				String 장소 = 수집결과.getString("place");
				String 전시실 = 수집결과.getString("hall");
				String 시작날 = 수집결과.getString("startday");
				String 마지막날 = 수집결과.getString("endday");

				Exhibition 찾은전시 = new Exhibition();

				찾은전시.setNo(번호);
				찾은전시.setTitle(제목);
				찾은전시.setPlace(장소);
				찾은전시.setHall(전시실);
				찾은전시.setStartday(시작날);
				찾은전시.setEndday(마지막날);

				찾은전시리스트.add(찾은전시);
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

		return 찾은전시리스트;
	}

	@Transactional
	public Exhibition findByNo(int no) {
		return exhibitionMapper.findByNo(no);
	}

	// 지난전시목록
	@Override
	@Transactional
	public List<Exhibition> listView2() {
		ArrayList<Exhibition> 지난전시리스트 = new ArrayList<Exhibition>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM exhibition WHERE endday<? ORDER BY no desc");
			명령자.setString(1, today);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 제목 = 수집결과.getString("title");
				String 장소 = 수집결과.getString("place");
				String 전시실 = 수집결과.getString("hall");
				String 시작날 = 수집결과.getString("startday");
				String 마지막날 = 수집결과.getString("endday");

				Exhibition 수집된전시 = new Exhibition();

				수집된전시.setNo(번호);
				수집된전시.setTitle(제목);
				수집된전시.setPlace(장소);
				수집된전시.setHall(전시실);
				수집된전시.setStartday(시작날);
				수집된전시.setEndday(마지막날);

				지난전시리스트.add(수집된전시);
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

		return 지난전시리스트;
	}

	// 지난전시목록 - title검색
	@Override
	@Transactional
	public List<Exhibition> findByTitle2(String title) {
		ArrayList<Exhibition> 찾은지난전시리스트 = new ArrayList<Exhibition>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM exhibition WHERE title like ? and endday<? ORDER BY no desc");
			명령자.setString(1, "%"+title+"%");
			명령자.setString(2, today);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 제목 = 수집결과.getString("title");
				String 장소 = 수집결과.getString("place");
				String 전시실 = 수집결과.getString("hall");
				String 시작날 = 수집결과.getString("startday");
				String 마지막날 = 수집결과.getString("endday");

				Exhibition 찾은전시 = new Exhibition();

				찾은전시.setNo(번호);
				찾은전시.setTitle(제목);
				찾은전시.setPlace(장소);
				찾은전시.setHall(전시실);
				찾은전시.setStartday(시작날);
				찾은전시.setEndday(마지막날);

				찾은지난전시리스트.add(찾은전시);
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

		return 찾은지난전시리스트;
	}

	public void delete(int no) {
		exhibitionMapper.delete(no);
	}

	// main1
	@Override
	@Transactional
	public List<Exhibition> newListView() {
		ArrayList<Exhibition> 전시리스트 = new ArrayList<Exhibition>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM exhibition WHERE endday>=? ORDER BY wdate desc LIMIT 3");
			명령자.setString(1, today);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 제목 = 수집결과.getString("title");
				String 장소 = 수집결과.getString("place");
				String 시작날 = 수집결과.getString("startday");
				String 마지막날 = 수집결과.getString("endday");
				byte[] 포스터 = 수집결과.getBytes("poster");

				Exhibition 수집된전시 = new Exhibition();

				수집된전시.setNo(번호);
				수집된전시.setTitle(제목);
				수집된전시.setPlace(장소);
				수집된전시.setStartday(시작날);
				수집된전시.setEndday(마지막날);
				수집된전시.setPoster(포스터);

				전시리스트.add(수집된전시);
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

		return 전시리스트;
	}

	// main2
	@Override
	@Transactional
	public List<Exhibition> topListView() {
		ArrayList<Exhibition> 전시리스트 = new ArrayList<Exhibition>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT exhibition_no,count(*) as cnt,title,place,startday,endday,poster FROM ticket,exhibition WHERE ticket.exhibition_no=exhibition.no and endday>=? GROUP BY exhibition_no LIMIT 3");
			명령자.setString(1, today);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("exhibition_no");
				String 제목 = 수집결과.getString("title");
				String 장소 = 수집결과.getString("place");
				String 시작날 = 수집결과.getString("startday");
				String 마지막날 = 수집결과.getString("endday");
				byte[] 포스터 = 수집결과.getBytes("poster");

				Exhibition 수집된전시 = new Exhibition();

				수집된전시.setNo(번호);
				수집된전시.setTitle(제목);
				수집된전시.setPlace(장소);
				수집된전시.setStartday(시작날);
				수집된전시.setEndday(마지막날);
				수집된전시.setPoster(포스터);

				전시리스트.add(수집된전시);
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

		return 전시리스트;
	}

	// main3
	@Override
	@Transactional
	public List<Exhibition> closeListView() {
		ArrayList<Exhibition> 전시리스트 = new ArrayList<Exhibition>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT * FROM exhibition WHERE endday>=? ORDER BY endday LIMIT 3");
			명령자.setString(1, today);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 제목 = 수집결과.getString("title");
				String 장소 = 수집결과.getString("place");
				String 시작날 = 수집결과.getString("startday");
				String 마지막날 = 수집결과.getString("endday");
				byte[] 포스터 = 수집결과.getBytes("poster");

				Exhibition 수집된전시 = new Exhibition();

				수집된전시.setNo(번호);
				수집된전시.setTitle(제목);
				수집된전시.setPlace(장소);
				수집된전시.setStartday(시작날);
				수집된전시.setEndday(마지막날);
				수집된전시.setPoster(포스터);

				전시리스트.add(수집된전시);
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

		return 전시리스트;
	}

	// 전시목록
	@Override
	@Transactional
	public List<Exhibition> listView(Integer order) {
		ArrayList<Exhibition> 전시리스트 = new ArrayList<Exhibition>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			if (order == 0) 명령자 = DB연결관리자.prepareStatement("SELECT * FROM exhibition WHERE endday>=? ORDER BY title");
			else if (order == 1) 명령자 = DB연결관리자.prepareStatement("SELECT * FROM exhibition WHERE endday>=? ORDER BY wdate desc");
			else if (order == 2) 명령자 = DB연결관리자.prepareStatement("SELECT * FROM exhibition WHERE endday>=? ORDER BY endday");
			명령자.setString(1, today);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("no");
				String 제목 = 수집결과.getString("title");
				String 장소 = 수집결과.getString("place");
				String 시작날 = 수집결과.getString("startday");
				String 마지막날 = 수집결과.getString("endday");

				Exhibition 수집된전시 = new Exhibition();

				수집된전시.setNo(번호);
				수집된전시.setTitle(제목);
				수집된전시.setPlace(장소);
				수집된전시.setStartday(시작날);
				수집된전시.setEndday(마지막날);

				전시리스트.add(수집된전시);
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

		return 전시리스트;
	}

	// 장소목록
	@Override
	@Transactional
	public List<Exhibition> findByPlaceNo(int no) {
		ArrayList<Exhibition> 전시리스트 = new ArrayList<Exhibition>();

		try {
			DB연결관리자 = ConnectionUtil.getConnection();
			명령자 = DB연결관리자.prepareStatement("SELECT exhibition.no,title,place,startday,endday FROM place,exhibition WHERE place.name=exhibition.place and place.no=? and endday>=?");
			명령자.setInt(1, no);
			명령자.setString(2, today);

			수집결과 = 명령자.executeQuery();

			while (수집결과.next()) {
				int 번호 = 수집결과.getInt("exhibition.no");
				String 제목 = 수집결과.getString("title");
				String 장소 = 수집결과.getString("place");
				String 시작날 = 수집결과.getString("startday");
				String 마지막날 = 수집결과.getString("endday");

				Exhibition 수집된전시 = new Exhibition();

				수집된전시.setNo(번호);
				수집된전시.setTitle(제목);
				수집된전시.setPlace(장소);
				수집된전시.setStartday(시작날);
				수집된전시.setEndday(마지막날);

				전시리스트.add(수집된전시);
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

		return 전시리스트;
	}
}