package com.stone.ui_manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.common_exhibition.Exhibition;
import com.stone.common_place.Place;
import com.stone.dataservice_exhibition.IExhibitionDAO;
import com.stone.dataservice_place.IPlaceDAO;
import com.stone.dataservice_ticket.ITicketDAO;

@Controller
public class ManageExhibitionController {

	@Autowired IExhibitionDAO exhibitionDAO;
	@Autowired IPlaceDAO placeDAO;
	@Autowired ITicketDAO ticketDAO;

	// 전시등록
	@GetMapping("/manager/exhibition")
	public String 전시등록준비하다() {
		// 경로
		return "manager/exhibition/전시등록";
	}

	// 전시등록
	@RequestMapping("/manager/exhibition")
	public ModelAndView 전시등록하다(@ModelAttribute Exhibition exhibition) {
		// 업무
		exhibitionDAO.save(exhibition);
		List<Exhibition> exhibitions = exhibitionDAO.listView();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/exhibition/전시목록");
		mv.addObject("exhibitions", exhibitions);
		return mv;
	}

	// 전시목록
	@GetMapping("/manager/exhibitions")
	public ModelAndView 전시목록출력하다() {
		// 업무
		List<Exhibition> exhibitions = exhibitionDAO.listView();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/exhibition/전시목록");
		mv.addObject("exhibitions", exhibitions);
		return mv;
	}

	// 전시목록 - title검색
	@RequestMapping("/manager/exhibitions/search")
	public ModelAndView 전시목록검색하다(String srchTitle) {
		// 업무
		List<Exhibition> exhibitions = exhibitionDAO.findByTitle(srchTitle);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/exhibition/전시목록");
		mv.addObject("exhibitions", exhibitions);
		return mv;
	}

	// 전시상세
	@RequestMapping("/manager/exhibitions/{no}")
	public ModelAndView 전시상세출력하다(@PathVariable("no") int no) {
		// 업무
		Exhibition exhibition = exhibitionDAO.findByNo(no);
		Place place = placeDAO.findByPlace(exhibition.getPlace());

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/exhibition/전시상세");
		mv.addObject("exhibition", exhibition);
		mv.addObject("place", place);
		return mv;
	}

	// 전시삭제
	@RequestMapping("/manager/exhibitions/delete")
	public ModelAndView 전시삭제하다(int no) {
		// 업무
		if (ticketDAO.isIn(no) == true) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("manager/exhibition/전시삭제실패");
			return mv;
		}
		else {
			exhibitionDAO.delete(no);
		}
		List<Exhibition> exhibitions = exhibitionDAO.listView();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/exhibition/전시목록");
		mv.addObject("exhibitions", exhibitions);
		return mv;
	}

	// 지난전시목록
	@RequestMapping("/manager/finished")
	public ModelAndView 지난전시목록출력하다() {
		// 업무
		List<Exhibition> exhibitions = exhibitionDAO.listView2();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/exhibition/지난전시목록");
		mv.addObject("exhibitions", exhibitions);
		return mv;
	}

	// 지난전시목록 - title검색
	@RequestMapping("/manager/finished/search")
	public ModelAndView 지난전시목록검색하다(String srchTitle) {
		// 업무
		List<Exhibition> exhibitions = exhibitionDAO.findByTitle2(srchTitle);

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager/exhibition/지난전시목록");
		mv.addObject("exhibitions", exhibitions);
		return mv;
	}
}