package com.stone.ui_member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.common_exhibition.Exhibition;
import com.stone.service_member.IMainService;

@Controller
public class MainController {

	@Autowired IMainService mainService;

	@GetMapping("/main")
	public ModelAndView process() {
		// 업무
		List<Exhibition> exhibitions1 = mainService.process1();
		List<Exhibition> exhibitions2 = mainService.process2();
		List<Exhibition> exhibitions3 = mainService.process3();

		// 경로
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("exhibitions1", exhibitions1);
		mv.addObject("exhibitions2", exhibitions2);
		mv.addObject("exhibitions3", exhibitions3);
		return mv;
	}
}