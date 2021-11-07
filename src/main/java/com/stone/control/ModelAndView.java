package com.stone.control;

import java.util.HashMap;

public class ModelAndView {

	String viewName = null;
	HashMap<String,Object> model = new HashMap<String,Object>();

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public void addObject(String key, Object val) {
		model.put(key, val);
	}
}