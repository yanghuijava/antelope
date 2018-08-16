package com.yanghui.antelope.service.system;

import java.util.List;

import com.yanghui.antelope.domain.system.Resource;

public interface ResourceService {

	public List<Resource> getUserSubResources(Long userId, String parentCode,List<Integer> types);

	public void delete(Long resId);

	public Resource getUserResource(Long userId, String code);

}
