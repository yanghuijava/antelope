package com.yanghui.antelope.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.constant.ResponseMsgEnum;
import com.yanghui.antelope.dao.system.UserMapper;
import com.yanghui.antelope.domain.system.Resource;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.system.ResourceService;
import com.yanghui.antelope.web.vo.Wrapper;

/**
 * 登入拦截器
 * @author yanghui
 *
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private UserMapper userMapper;
	 

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		User user = (User)request.getSession().getAttribute(Constant.USER_SESSION_NAME);
		if(user == null){
			if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
				response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
				//response.getWriter().print("timeout");
				return false;
			}
			request.setAttribute("targerUrl",request.getServletPath());
			request.getRequestDispatcher("/login.html?loginFlag=true").forward(request, response);
			return false;
		}else{
			if("admin".equals(user.getAccount())){
				return true;
			}
			String requestUrl = request.getRequestURL().toString();
			if(!(requestUrl.contains("/index.html") || requestUrl.contains("/updatePwdUI.html")
					|| requestUrl.contains("/updatePwd.json")
					|| requestUrl.contains("/rightUI.html")
					|| requestUrl.contains("/noUpdatePwd.html")
					|| requestUrl.contains("/404.html")
					|| requestUrl.contains("/error.html")
				 )
				){
				User find = this.userMapper.selectById(user.getId());
				if(find.getStatus() == 1){
					response.setHeader("sessionstatus", "pwdstatus");//在响应头设置session状态
					request.getRequestDispatcher("/common/noUpdatePwd.html").forward(request, response);
					return false;
				}
			}
			for(Resource r : user.getResourceList()) {
				if(!StringUtils.isEmpty(r.getUrl()) && requestUrl.contains(r.getUrl())){
					return true;
				}
			}
			if(requestUrl.endsWith(".html")){
				request.getRequestDispatcher("/common/404.html").forward(request, response);
			}else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=UTF-8");
				Wrapper<?> result = new Wrapper<>();
				result.setSuccess(false);
				result.setError(true);
				result.setCode(ResponseMsgEnum.NOAUTH.getCode());
				result.setMessage(ResponseMsgEnum.NOAUTH.getMessage());
				ObjectMapper mapper = new ObjectMapper();
				response.getWriter().write(mapper.writeValueAsString(result));
			}
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
	}
}
