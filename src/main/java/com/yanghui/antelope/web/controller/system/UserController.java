package com.yanghui.antelope.web.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.common.utils.HttpKit;
import com.yanghui.antelope.common.utils.TransformationUtil;
import com.yanghui.antelope.dao.system.UserMapper;
import com.yanghui.antelope.domain.system.Role;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.system.UserService;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.PageResult;
import com.yanghui.antelope.web.vo.Wrapper;

@Controller
@RequestMapping("/user")
public class UserController extends BaseComtroller{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/listUI.html")
	public String listUI(){
		return "system/user/user_listUI";
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResult<User> list(Condition condition){
		List<User> userList = this.userService.queryPage(condition.getPagination(),condition.getMap());
		return createPage(condition.getPagination(), userList);
	}
	
	@RequestMapping("/save.json")
	@ResponseBody
	public Map<String,Object> save(Condition condition) throws Exception{
		Map<String,Object> map = condition.getMap();
		User user = TransformationUtil.toObject(map, User.class);
		User userSession = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		user.setCreateBy(userSession.getId());
		user.setUpdateBy(userSession.getId());
		List<Role> roleList = new ArrayList<Role>();
		if(!StringUtils.isEmpty(map.get("roleIds")) && map.get("roleIds").toString().length() > 0){
			String[] roleIdArr = map.get("roleIds").toString().split(",");
			for(String roleId : roleIdArr){
				Role role = new Role();
				role.setId(Long.valueOf(roleId));
				roleList.add(role);
			}
		}
		this.userService.save(user,roleList);
		return edatagridSuccessResult(map,user.getId());
	}
	
	@RequestMapping("/update.json")
	@ResponseBody
	public Map<String,Object> update(Condition condition) throws Exception{
		Map<String,Object> map = condition.getMap();
		User user = TransformationUtil.toObject(map, User.class);
		User find = this.userMapper.selectById(Long.valueOf(map.get("id").toString()));
		User userSession = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		user.setCreateBy(null);
		user.setCreateTime(null);
		user.setUpdateBy(userSession.getId());
		List<Role> roleList = new ArrayList<Role>();
		if(!StringUtils.isEmpty(map.get("roleIds")) && map.get("roleIds").toString().length() > 0){
			String[] roleIdArr = map.get("roleIds").toString().split(",");
			for(String roleId : roleIdArr){
				Role role = new Role();
				role.setId(Long.valueOf(roleId));
				roleList.add(role);
			}
		}
		this.userService.update(user,roleList);
		return edatagridSuccessResult(map, find.getId());
	}
	@RequestMapping("/delete.json")
	@ResponseBody
	public Wrapper<?> delete(Condition condition){
		this.userService.delete(Long.valueOf(condition.getMap().get("id").toString()));
		return successWrapper();
	}
	
	@RequestMapping("/frozen.json")
	@ResponseBody
	public Wrapper<?> frozen(Condition condition){
		User user = this.userMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		if(user.getAccount().equals("admin")){
			throw new BusinessExcption(Constant.USERFROZEN_ERROR);
		}
		user.setStatus(0);
		this.userMapper.updateById(user);
		return successWrapper();
	}
	
	@RequestMapping("/unfrozen.json")
	@ResponseBody
	public Wrapper<?> unfrozen(Condition condition){
		User user = this.userMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		if(user.getAccount().equals("admin")){
			throw new BusinessExcption(Constant.USERUNFROZEN_ERROR);
		}
		user.setStatus(1);
		this.userMapper.updateById(user);
		return successWrapper();
	}
	@RequestMapping("/getAccountManager.json")
	@ResponseBody
	public List<Map<String,Object>> getAccountManager(){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		List<User> data = this.userMapper.getUserByRoleCode(Constant.ROLE_CODE_KEHUJINGLI);
		for(User u : data){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("accountManager", u.getId());
			map.put("name",u.getName());
			result.add(map);
		}
		return result;
	}
}
