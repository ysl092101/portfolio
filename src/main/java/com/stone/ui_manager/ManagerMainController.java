package com.stone.ui_manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerMainController {

	@GetMapping("/manager/main")
	public String process() {
		// 경로
		return "manager/main";
	}
}