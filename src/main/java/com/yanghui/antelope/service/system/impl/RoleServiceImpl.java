package com.yanghui.antelope.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.constant.ResponseMsgEnum;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.dao.system.RoleMapper;
import com.yanghui.antelope.dao.system.RoleResourceMapper;
import com.yanghui.antelope.dao.system.UserRoleMapper;
import com.yanghui.antelope.domain.system.Role;
import com.yanghui.antelope.domain.system.RoleResource;
import com.yanghui.antelope.service.system.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleResourceMapper roleResourceMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveRoleResource(Long roleId, String resIds) {
		if(roleId != null){
			this.roleMapper.deleteRoleResource(roleId);
			if(resIds != null) {
				String[] resIdArr = resIds.split(",");
				this.roleMapper.deleteRoleResource(roleId);
				for(String resId : resIdArr){
					if(StringUtils.isEmpty(resId) || Integer.valueOf(resId) == 0) {
						continue;
					}
					RoleResource rr = new RoleResource();
					rr.setRoleId(roleId.intValue());
					rr.setResId(Integer.valueOf(resId));
					this.roleResourceMapper.insert(rr);
				}
			}
		}else {
			throw new BusinessExcption(ResponseMsgEnum.ROLEIDNOTNULL);
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteById(Long id) {
		Role role = this.roleMapper.selectById(id);
		if(role != null && role.getCode().equals("administrator")){
			throw new BusinessExcption(Constant.ROLEDELETE_ERROR);
		}
		List<Role> findList = this.userRoleMapper.queryByRoleId(id);
		if(findList != null && findList.size() > 0){
			throw new BusinessExcption(Constant.ROLEDELETE_USERED);
		}
		this.roleMapper.deleteById(id);
		this.roleResourceMapper.deleteByRoleId(id);
	}
}
