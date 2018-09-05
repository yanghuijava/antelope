package com.yanghui.antelope.web.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.system.UserService;
import com.yanghui.antelope.web.vo.Condition;

@Controller
public class LoginController {
	
	public final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/common/testjson.json")
	@ResponseBody
	public String testjson(){
		return "testjson";
	}
	
	@RequestMapping("/common/404.html")
	public String to404(){
		return "common/404";
	}
	
	@RequestMapping("/common/noUpdatePwd.html")
	public String toNoUpdatePwd(){
		return "common/noUpdatePwd";
	}
	
	@RequestMapping(value={"/","index.html"})
	public String index(){
		return "index";
	}
	
	@RequestMapping("rightUI.html")
	public String rightUI(){
		return "rightUI";
	}
	
	@RequestMapping("login.html")
	public String login(Model model,@RequestParam(value="loginFlag",required=false) String loginFlag){
		if(!StringUtils.isEmpty(loginFlag)){
			model.addAttribute("loginFlag", loginFlag);
		}
		return "login";
	}
	
	@RequestMapping("/loginExecute.html")
	public String executeLogin(Model model,Condition condition,HttpServletRequest request){
		Object account = condition.getMap().get("account");
		Object password = condition.getMap().get("password");
		logger.info("登入，账号：{}，密码：{}",account,password);
		if(account == null || "".equals(account.toString().trim())) {
			model.addAttribute("errorMsg", "登入账号不能为空！");
			model.addAttribute("targerUrl", condition.getMap().get("targerUrl"));
			return "login";
		}
		if(password == null || "".equals(password.toString().trim())){
			model.addAttribute("errorMsg", "密码不能为空！");
			model.addAttribute("targerUrl", condition.getMap().get("targerUrl"));
			return "login";
		}
		User user = null;
		try {
			user = this.userService.checkUser(account.toString(), password.toString());
		} catch (BusinessExcption e) {
			logger.error("发生异常：{}",e);
			model.addAttribute("errorMsg", e.getMessage());
			model.addAttribute("targerUrl", condition.getMap().get("targerUrl"));
			return "login";
		}
		if(user == null) {
			model.addAttribute("errorMsg", "账号或者密码错误！");
			model.addAttribute("targerUrl", condition.getMap().get("targerUrl"));
			return "login";
		}
		request.getSession().setAttribute(Constant.USER_SESSION_NAME, user);
		if(condition.getMap().get("targerUrl") != null && !"".equals(condition.getMap().get("targerUrl"))) {
			return "redirect:" + condition.getMap().get("targerUrl").toString();
		}
		return "redirect:/index.html";
	}
	
	@RequestMapping("/logout.html")
	public String out(HttpServletRequest request){
		request.getSession().removeAttribute(Constant.USER_SESSION_NAME);
		return "redirect:/login.html";
	}
}
