package com.stone.util;

public class ViewResolver {

	private static String path = "WEB-INF/views/";

	public static String getViewName(String viewName) {
		if (viewName.contains("forward:/")) { // forward:/일 때
			return viewName.substring("forward:/".length() - 1) + ".jsp";
		}

		// view일 때
		return path + viewName + ".jsp";
	}
}