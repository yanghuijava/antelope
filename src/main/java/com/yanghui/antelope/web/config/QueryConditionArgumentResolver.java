package com.yanghui.antelope.web.config;

import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.web.vo.Condition;

public class QueryConditionArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return (parameter.getParameterType() == Condition.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		Condition condition = new Condition();
		Map<String, String[]> map = webRequest.getParameterMap();
		String page = null;
		String rows = null;
		for (String key : map.keySet()) {
			if (key.equals("page")) {
				page = map.get(key)[0];
			} else if (key.equals("rows")) {
				rows = map.get(key)[0];
			}else {
				condition.getMap().put(key, map.get(key)[0]);
			}
		}
		if(page != null && rows != null){
			condition.setPagination(new Pagination(Integer.valueOf(page), Integer.valueOf(rows)));
		}else {
			condition.setPagination(new Pagination(1, 10));
		}
		return condition;
	}
}
