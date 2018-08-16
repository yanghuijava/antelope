package com.yanghui.antelope.web.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.constant.ResourceType;
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
public class ToolbarDirective implements TemplateDirectiveModel{
	
	@javax.annotation.Resource
	private ResourceService resourceService;

	@Override
	@SuppressWarnings("rawtypes")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,TemplateDirectiveBody body) throws TemplateException, IOException {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		User user = request.getSession().getAttribute(Constant.USER_SESSION_NAME) == null ? new User() :(User)request.getSession().getAttribute(Constant.USER_SESSION_NAME);
		if(!params.isEmpty()) {
			StringBuffer bodyText = new StringBuffer();
			String code = null;
			if(params.get("code") != null){
				code = ((SimpleScalar) params.get("code")).getAsString();
			}else {
				throw new RuntimeException("code is not empty!");
			}
			List<Integer> types = new ArrayList<Integer>();
			types.add(ResourceType.BUTTON.getType());
			List<Resource> resourceList = null;
			if("admin".equals(user.getAccount())){
				resourceList = this.resourceService.getUserSubResources(null, code, types);
			}else {
				resourceList = this.resourceService.getUserSubResources(user.getId(), code, types);
			}
			bodyText.append("toolbar: [");
			if(resourceList != null && resourceList.size() > 0){
				for(Resource r : resourceList){
					bodyText.append("{text:'").append(r.getName()).append("',iconCls:'").append(r.getIcon())
							.append("',handler:").append(r.getAction()).append("},");
				}
				bodyText.deleteCharAt(bodyText.length() - 1);
			}
			bodyText.append("]");
//			System.out.println(bodyText);
			env.getOut().write(bodyText.toString());
		}else {
			throw new RuntimeException("params is not empty!");
		}
	}
}
