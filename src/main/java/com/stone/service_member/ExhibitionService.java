package com.stone.service_member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stone.common_exhibition.Exhibition;
import com.stone.dataservice_exhibition.IExhibitionDAO;

@Service
public class ExhibitionService implements IExhibitionService {

	@Autowired IExhibitionDAO exhibitionDAO;

	@Override
	@Transactional
	public List<Exhibition> process1(Integer order) {
		if (order == null) order = 0;
		return exhibitionDAO.listView(order);
	}

	@Override
	@Transactional
	public Exhibition process2(int no) {
		return exhibitionDAO.findByNo(no);
	}

	@Override
	@Transactional
	public List<Exhibition> process3(int no) {
		return exhibitionDAO.findByPlaceNo(no);
	}
}