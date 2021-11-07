package com.stone.ui_member;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.common_exhibition.Exhibition;
import com.stone.dataservice_exhibition.IExhibitionDAO;

@Controller
public class PosterController {

	@Autowired IExhibitionDAO exhibitionDAO;

	@RequestMapping("/poster/{no}")
	public void process(HttpServletRequest request, HttpServletResponse response, @PathVariable("no") int no) {
		Exhibition exhibition = exhibitionDAO.findByNo(no);
		byte [] poster = (byte [])exhibition.getPoster();
		response.setContentType("image/jpeg");

		try {
			OutputStream os = response.getOutputStream();
			os.write(poster);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}