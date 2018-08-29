package com.yanghui.antelope.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.common.utils.MD5Util;
import com.yanghui.antelope.dao.system.ResourceMapper;
import com.yanghui.antelope.dao.system.RoleMapper;
import com.yanghui.antelope.dao.system.UserMapper;
import com.yanghui.antelope.dao.system.UserRoleMapper;
import com.yanghui.antelope.domain.system.Resource;
import com.yanghui.antelope.domain.system.Role;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.domain.system.UserRole;
import com.yanghui.antelope.service.system.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private ResourceMapper resourceMapper;
	@Override
	public User checkUser(String account, String password) {
		User user = this.userMapper.selectByAccount(account);
		if(user == null){
			return null;
		}
		if(!user.getPassword().equals(MD5Util.encryption(password))){
			return null;
		}
		if(user.getStatus() == 0){
			throw new BusinessExcption(Constant.USERSTATUS_ERROR);
		}
		List<Resource> resourceList = this.resourceMapper.getUserAllResource(user.getId());
		user.setResourceList(resourceList);
		User u = this.queryUserAllMsg(user.getId());
		user.setRoleNames(u.getRoleNames());
		user.setRoleCodes(u.getRoleCodes());
		return user;
	}

	@Override
	@Transactional
	public void save(User user, List<Role> roleList) {
		if(StringUtils.isEmpty(user.getAccount())) {
			throw new BusinessExcption(Constant.ACCOUNT_NULL);
		}
		User find = this.userMapper.selectByAccount(user.getAccount());
		if(find != null) {
			throw new BusinessExcption(Constant.ACCOUNT_CHONGFU);
		}
		user.setPassword(MD5Util.encryption("888888"));
		this.userMapper.insert(user);
		if(roleList != null && roleList.size() > 0) {
			for(Role role : roleList){
				UserRole ur = new UserRole();
				ur.setUserId(user.getId().intValue());
				ur.setRoleId(role.getId().intValue());
				this.userRoleMapper.insert(ur);
			}
		}
	}

	@Override
	public void update(User user, List<Role> roleList) {
		if(user.getAccount().equals("admin")){
			roleList = null;
		}else {
			this.userRoleMapper.deleteUserRole(user.getId());
		}
		user.setAccount(null);
		if(roleList != null && roleList.size() > 0) {
			for(Role role : roleList){
				UserRole ur = new UserRole();
				ur.setUserId(user.getId().intValue());
				ur.setRoleId(role.getId().intValue());
				this.userRoleMapper.insert(ur);
			}
		}
		this.userMapper.updateById(user);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void delete(Long userId) {
		User user = this.userMapper.selectById(userId);
		if("admin".equals(user.getAccount())){
			throw new BusinessExcption(Constant.USERDELETE_ERROR);
		}
		this.userMapper.deleteById(userId);
		this.userRoleMapper.deleteUserRole(userId);
	}

	@Override
	public List<User> queryPage(Pagination pagination,Map<String, Object> params) {
		List<User> userList = this.userMapper.queryPage(pagination, params);
		for(User u : userList){
			List<UserRole> urList = this.userRoleMapper.selectRoleByUserId(u.getId());
			StringBuffer roleIds = new StringBuffer();
			for(UserRole ur : urList){
				roleIds.append(ur.getRoleId()).append(",");
			}
			if(roleIds.length() > 0){
				roleIds.deleteCharAt(roleIds.length() - 1);
				u.setRoleIds(roleIds.toString());
			}
		}
		return userList;
	}

	@Override
	public User queryUserAllMsg(Long id) {
		User user = this.userMapper.selectById(id);
		List<UserRole> urList = this.userRoleMapper.selectRoleByUserId(id);
		StringBuffer roleNames = new StringBuffer();
		StringBuffer roleCodes = new StringBuffer();
		for(UserRole ur : urList){
			Role r = this.roleMapper.selectById(ur.getRoleId());
			roleNames.append(r.getName()).append(",");
			roleCodes.append(r.getCode()).append(",");
		}
		roleNames.deleteCharAt(roleNames.length() - 1);
		user.setRoleNames(roleNames.toString());
		roleCodes.deleteCharAt(roleCodes.length() - 1);
		user.setRoleCodes(roleCodes.toString());
		return user;
	}
}
