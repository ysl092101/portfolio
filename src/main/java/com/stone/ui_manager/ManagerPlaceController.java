package com.stone.ui_manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.common_place.Place;
import com.stone.dataservice_place.IPlaceDAO;

@Controller
public class ManagerPlaceController {

	@Autowired IPlaceDAO placeDAO;

	// 장소등록
	@GetMapping("/manager/place")
	public String 장소등록준비하다() {
		// 경로
		return "manager/place/장소등록";
	}

	// 장소등록 → 장소목록
	@RequestMapping("/manager/place")
	public ModelAndView 장소등록하다(@ModelAttribute Place place) {
		// 업무
		placeDAO.save(place);
		List<Place> places = placeDAO.listView();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/place/장소목록");
		mv.addObject("places", places);
		return mv;
	}

	// 장소목록
	@GetMapping("/manager/places")
	public ModelAndView 장소목록출력하다() {
		// 업무
		List<Place> places = placeDAO.listView();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/place/장소목록");
		mv.addObject("places", places);
		return mv;
	}

	// 장소목록 - name검색
	@RequestMapping("/manager/places/search")
	public ModelAndView 장소목록검색하다(String srchName) {
		// 업무
		List<Place> places = placeDAO.findByName(srchName);

		// 경로	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/place/장소목록");
		mv.addObject("places", places);
		return mv;
	}

	// 장소삭제 → 장소목록
	@RequestMapping("/manager/places/delete")
	public ModelAndView 장소삭제하다(int no) {
		// 업무
		placeDAO.delete(no);
		List<Place> places = placeDAO.listView();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/place/장소목록");
		mv.addObject("places", places);
		return mv;
	}

	// (전시등록)장소검색
	@GetMapping("/manager/exhibition/places")
	public ModelAndView 전시등록에서장소검색준비하다() {
		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/place/장소검색");
		return mv;
	}

	// (전시등록)장소검색 - name검색
	@RequestMapping("/manager/exhibition/places/search")
	public ModelAndView 전시등록에서장소검색하다(String srchName) {
		// 업무
		List<Place> places = placeDAO.findByName(srchName);

		// 경로	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/place/장소검색");
		mv.addObject("places", places);
		return mv;
	}
}