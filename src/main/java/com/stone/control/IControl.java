package com.stone.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IControl {

	ModelAndView process(HttpServletRequest request, HttpServletResponse response);
}