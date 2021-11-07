package com.stone.env;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { // HttpServletRequest
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		boolean 로그인 = false;

		if (session!=null && session.getAttribute("no")!=null) {
			로그인 = true;
		}

		if (!로그인) {
			request.setAttribute("message", "로그인 후 이용이 가능합니다.");
			RequestDispatcher rd = request.getRequestDispatcher("/login");
			rd.forward(request, response);
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}