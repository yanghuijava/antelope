package com.yanghui.antelope.web.excption;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yanghui.antelope.common.constant.ResponseMsgEnum;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.web.vo.Wrapper;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	public static final String DEFAULT_ERROR_VIEW = "common/error";
	private static final String KEY = "exception";
	
	@ExceptionHandler(value = Throwable.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Throwable e) throws Exception {
		logger.error("访问：{},发生异常啦,异常信息：{}", request.getRequestURL(),e);
		if(request.getRequestURL().indexOf(".html") > 0){
			return renderErrorView(request, e);
		}
        return renderErrorJson(e);
    }
	
	private ModelAndView renderErrorView(HttpServletRequest request, Throwable e) {
		ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
	
	public ModelAndView renderErrorJson(Throwable e) {
        /** json错误  **/
		Wrapper<?> result = new Wrapper<>();
		if(e instanceof BusinessExcption){
			BusinessExcption be = (BusinessExcption)e;
			result.setCode(be.getCode());
			result.setMessage(be.getMessage());
		}else {
			result.setCode(ResponseMsgEnum.ERROR.getCode());
			result.setMessage(ResponseMsgEnum.ERROR.getMessage());
		}
		result.setSuccess(false);
		result.setError(true);
		ModelAndView mv = new ModelAndView(new View() {
			private static final String CONTENT_TYPE = "application/json;charset=utf-8";
			@Override
			public void render(Map<String, ?> model, HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				Wrapper<?> result = (Wrapper<?>)model.get(KEY);
				ObjectMapper objectMapper = new ObjectMapper();
				response.setContentType(CONTENT_TYPE);
	            response.getOutputStream().write(objectMapper.writeValueAsBytes(result));
	            response.getOutputStream().flush();
			}
			@Override
			public String getContentType() {
				return CONTENT_TYPE;
			}
		});
		mv.addObject(KEY, result);
        return mv;
    }
	
//	@ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public Wrapper<?> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//		logger.error("访问：{},发生异常啦,异常信息：{}", req.getRequestURL(),e);
//		Wrapper<?> result = new Wrapper<>();
//		if(e instanceof BusinessExcption){
//			BusinessExcption be = (BusinessExcption)e;
//			result.setCode(be.getCode());
//			result.setMessage(be.getMessage());
//		}else {
//			e.printStackTrace();
//			result.setCode(ResponseMsgEnum.ERROR.getCode());
//			result.setMessage(ResponseMsgEnum.ERROR.getMessage());
//		}
//		result.setSuccess(false);
//		result.setError(true);
//        return result;
//    }
}
