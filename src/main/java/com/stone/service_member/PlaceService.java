package com.stone.service_member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stone.common_place.Place;
import com.stone.dataservice_place.IPlaceDAO;

@Service
public class PlaceService implements IPlaceService {

	@Autowired IPlaceDAO placeDAO;
	
	@Override
	@Transactional
	public Place process1(String name) {
		return placeDAO.findByPlace(name);
	}
}