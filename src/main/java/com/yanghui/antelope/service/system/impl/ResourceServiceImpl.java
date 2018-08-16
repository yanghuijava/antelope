package com.yanghui.antelope.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.dao.system.ResourceMapper;
import com.yanghui.antelope.dao.system.RoleResourceMapper;
import com.yanghui.antelope.domain.system.Resource;
import com.yanghui.antelope.domain.system.RoleResource;
import com.yanghui.antelope.service.system.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService{
	
	@Autowired
	private ResourceMapper resourceMapper;
	@Autowired
	private RoleResourceMapper roleResourceMapper;

	@Override
	public List<Resource> getUserSubResources(Long userId, String parentCode,List<Integer> types) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("parentCode", parentCode);
		param.put("types", types);
		return this.resourceMapper.selectUserSubs(param);
	}
	
	@Override
	public Resource getUserResource(Long userId, String code) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("code", code);
		List<Resource> list = this.resourceMapper.selectUserSubs(param);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delete(Long resId) {
		List<RoleResource> rrList = this.roleResourceMapper.queryByResId(resId);
		if(rrList != null && rrList.size() > 0){
			throw new BusinessExcption("资源被引用不能被删除！");
		}
		this.resourceMapper.deleteById(resId);
	}
}
