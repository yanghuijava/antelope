package com.yanghui.antelope.web.controller.me;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.common.utils.HttpKit;
import com.yanghui.antelope.common.utils.MD5Util;
import com.yanghui.antelope.common.utils.TransformationUtil;
import com.yanghui.antelope.dao.system.UserMapper;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.system.UserService;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.Wrapper;

@Controller
@RequestMapping("/me")
public class MeController extends BaseComtroller{
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/personalUI.html")
	public String personalUI(Model model){
		User user = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		User findUser = this.userService.queryUserAllMsg(user.getId());
		model.addAttribute("findUser", findUser);
		return "me/personalUI";
	}
	
	@RequestMapping("/updatePwdUI.html")
	public String updatePwdUI(){
		return "me/updatePwdUI";
	}
	
	@RequestMapping("/getUserAllMsg.json")
	@ResponseBody
	public User getUserAllMsg(){
		User user = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		User findUser = this.userService.queryUserAllMsg(user.getId());
		return findUser;
	}
	
	@RequestMapping("/updatePersonal.json")
	@ResponseBody
	public Wrapper<?> updatePersonal(Condition condition) throws Exception{
		User userSession = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		Map<String,Object> map = condition.getMap();
		User user = TransformationUtil.toObject(map, User.class);
		user.setCreateBy(null);
		user.setCreateTime(null);
		user.setAccount(null);
		user.setUpdateBy(userSession.getId());
		this.userMapper.updateById(user);
		return successWrapper();
	}
	
	@RequestMapping("/updatePwd.json")
	@ResponseBody
	public Wrapper<?> updatePwd(Condition condition) throws Exception{
		String oldPwd = condition.getMap().get("oldPassword").toString();
		String newPassword = condition.getMap().get("newPassword").toString();
		String repPassword = condition.getMap().get("repPassword").toString();
		User userSession = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		User find = this.userMapper.selectById(userSession.getId());
		if(!find.getPassword().equals(MD5Util.encryption(oldPwd))){
			throw new BusinessExcption("原密码不正确！");
		}
		if(!newPassword.equals(repPassword)){
			throw new BusinessExcption("两次输入密码不相同！");
		}
		find.setPassword(MD5Util.encryption(newPassword));
		find.setStatus(2);
		this.userMapper.updateById(find);
		return successWrapper();
	}
}
