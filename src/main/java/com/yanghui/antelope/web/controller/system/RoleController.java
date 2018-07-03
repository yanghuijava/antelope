package com.yanghui.antelope.web.controller.system;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.common.utils.HttpKit;
import com.yanghui.antelope.common.utils.TransformationUtil;
import com.yanghui.antelope.dao.system.RoleMapper;
import com.yanghui.antelope.domain.system.Role;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.system.RoleService;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.PageResult;
import com.yanghui.antelope.web.vo.Wrapper;
@Controller
@RequestMapping("/role")
public class RoleController extends BaseComtroller {
	
	public final static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/listUI.html")
	public String listUI(){
		return "system/role/role_listUI";
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResult<Role> list(Condition condition){
		List<Role> data = this.roleMapper.selectPage(condition.getPagination(), null);
		return createPage(condition.getPagination(), data);
	}
	
	@RequestMapping("/save.json")
	@ResponseBody
	public Map<String,Object> save(Condition condition) throws Exception{
		Map<String,Object> map = condition.getMap();
		Role role = TransformationUtil.toObject(map, Role.class);
		User user = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		role.setCreateBy(user.getId());
		role.setUpdateBy(user.getId());
		Role find = this.roleMapper.queryByCode(role.getCode());
		if(find != null){
			throw new BusinessExcption(Constant.ROLECODE_ERROR);
		}
		this.roleMapper.insert(role);
		return edatagridSuccessResult(map, role.getId());
	}
	
	@RequestMapping("/update.json")
	@ResponseBody
	public Map<String,Object> update(Condition condition) throws Exception{
		Map<String,Object> map = condition.getMap();
		Role role = TransformationUtil.toObject(map, Role.class);
		User user = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
		Role find = this.roleMapper.selectById(role.getId());
		if("administrator".equals(find.getCode())){
			throw new BusinessExcption(Constant.ROLEDUPDATE_ERROR);
		}
		role.setCreateBy(null);
		role.setCreateTime(null);
		role.setUpdateBy(user.getId());
		role.setCode(null);
		this.roleMapper.updateById(role);
		return edatagridSuccessResult(map, role.getId());
	}
	
	@RequestMapping("/delete.json")
	@ResponseBody
	public Wrapper<?> delete(Condition condition){
		this.roleService.deleteById(Long.valueOf(condition.getMap().get("id").toString()));
		return successWrapper();
	}
	
	@RequestMapping("/queryRoleNames.json")
	@ResponseBody
	public Wrapper<String> queryRoleNames(Condition condition){
		String roleIds = condition.getMap().get("roleIds") == null ? null : condition.getMap().get("roleIds").toString();
		if(roleIds != null && !"".equals(roleIds)) {
			String[] roleIdArr = roleIds.split(",");
			StringBuffer roleNames = new StringBuffer();
			for(String roleId : roleIdArr){
				Role role = this.roleMapper.selectById(Long.valueOf(roleId));
				roleNames.append(role.getName()).append(",");
			}
			if(roleNames.length() > 0) {
				roleNames.deleteCharAt(roleNames.length() - 1);
			}
			return Wrapper.wrap(roleNames.toString(), true);
		}else {
			return Wrapper.wrap("", true);
		}
	}
	
	@RequestMapping("/listAll.json")
	@ResponseBody
	public List<Role> listAll(Condition condition){
		List<Role> data = this.roleMapper.selectList(null);
		return data;
	}
}
