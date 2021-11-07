package com.stone.ui_member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.common_exhibition.Exhibition;
import com.stone.common_place.Place;
import com.stone.service_member.IExhibitionService;
import com.stone.service_member.IPlaceService;

@Controller
public class ExhibitionPlaceController {

	@Autowired IExhibitionService exhibitionService;
	@Autowired IPlaceService placeService;

	// 전시목록
	@RequestMapping("/exhibitions")
	public ModelAndView 전시목록출력하다(Integer order) {
		// 업무
		List<Exhibition> exhibitions = exhibitionService.process1(order);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("전시목록");
		mv.addObject("exhibitions", exhibitions);
		return mv;
	}

	// 전시상세
	@RequestMapping("/exhibitions/{no}")
	public ModelAndView 전시상세출력하다(@PathVariable("no") int no) {
		// 업무
		Exhibition exhibition = exhibitionService.process2(no);
		Place place = placeService.process1(exhibition.getPlace());

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("전시상세");
		mv.addObject("exhibition", exhibition);
		mv.addObject("place", place);
		return mv;
	}

	// 장소목록
	@RequestMapping("/places/{no}")
	public ModelAndView 장소별전시목록출력하다(@PathVariable("no") int no) {
		// 업무
		List<Exhibition> exhibitions = exhibitionService.process3(no);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("장소목록");
		mv.addObject("exhibitions", exhibitions);
		return mv;
	}
}