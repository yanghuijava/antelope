package com.yanghui.antelope.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CommonInterceptor implements HandlerInterceptor{
	
	
	private static final String CONTEXT_RANDOM_VALUE = "rand";
	private static final String CONTEXT_BASE_PATH = "base";

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String path = request.getContextPath();
		String basePath = null;
		if (request.getServerPort() == 80) {
			basePath = request.getScheme() + "://" + request.getServerName() + path + "/";
		} else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
		}
		request.setAttribute(CONTEXT_BASE_PATH, basePath);
		request.setAttribute(CONTEXT_RANDOM_VALUE, ("" + Math.random()).substring(2, 8));
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)throws Exception {

	}
}
