package com.stone.service_member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stone.common_exhibition.Exhibition;
import com.stone.dataservice_exhibition.IExhibitionDAO;

@Service
public class MainService implements IMainService {

	@Autowired IExhibitionDAO exhibitionDAO;

	@Override
	@Transactional
	public List<Exhibition> process1() {
		return exhibitionDAO.topListView();
	}

	@Override
	@Transactional
	public List<Exhibition> process2() {
		return exhibitionDAO.newListView();
	}

	@Override
	@Transactional
	public List<Exhibition> process3() {
		return exhibitionDAO.closeListView();
	}
}