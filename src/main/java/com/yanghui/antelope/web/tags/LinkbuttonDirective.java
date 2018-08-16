package com.yanghui.antelope.web.tags;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.domain.system.Resource;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.system.ResourceService;

import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
@Component
public class LinkbuttonDirective implements TemplateDirectiveModel{
	
	@javax.annotation.Resource
	private ResourceService resourceService;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)throws TemplateException, IOException {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		User user = request.getSession().getAttribute(Constant.USER_SESSION_NAME) == null ? new User() :(User)request.getSession().getAttribute(Constant.USER_SESSION_NAME);
		if(params.isEmpty()) {
			throw new RuntimeException("params is not empty!");
		}
		StringBuffer bodyText = new StringBuffer();
		String code = getParam("code", params,true);
		String name = getParam("name", params,true);
		String iconCls = getParam("iconCls", params,true);
		String id = getParam("id", params,true);
		String style = getParam("style", params,false);
		Resource resource;
		if("admin".equals(user.getAccount())){
			resource = this.resourceService.getUserResource(null,code);
		}else {
			resource = this.resourceService.getUserResource(user.getId(),code);
		}
		if(resource != null) {
			bodyText.append("<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" data-options=\"iconCls:'")
					.append(iconCls)
					.append("'\" id=\"")
					.append(id)
					.append("\" style=\"")
					.append(style)
					.append("\">")
					.append(name)
					.append("</a>");
		}
		System.out.println(bodyText);
		env.getOut().write(bodyText.toString());
	}
	
	@SuppressWarnings("rawtypes")
	private String getParam(String p,Map params,boolean isMust) {
		String result = "";
		if(params.get(p) != null){
			result = ((SimpleScalar) params.get(p)).getAsString();
		}else {
			if(isMust) {
				throw new RuntimeException("code is not empty!");
			}
		}
		return result;
	}
}
