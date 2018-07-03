package com.yanghui.antelope.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.constant.ResourceType;
import com.yanghui.antelope.common.utils.HttpKit;
import com.yanghui.antelope.common.utils.TransformationUtil;
import com.yanghui.antelope.dao.system.ResourceMapper;
import com.yanghui.antelope.domain.system.Resource;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.service.system.ResourceService;
import com.yanghui.antelope.service.system.RoleService;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.TreeDto;
import com.yanghui.antelope.web.vo.Wrapper;
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseComtroller{
	
	private final static String PRIX = "system/resource/resource_";
	
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private ResourceMapper resourceMapper;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/queryRoleResource.json")
	@ResponseBody
	public List<TreeDto> queryRoleResource(Condition condition){
		List<TreeDto> treeList = new ArrayList<TreeDto>();
		TreeDto td = new TreeDto();
		td.setId(0);
		td.setText("系统资源");
		td.setState("open");
		treeList.add(td);
		if(!StringUtils.isEmpty(condition.getMap().get("roleId"))) {
			List<Resource> hasResource = this.resourceMapper.getResourceByRoleId(Long.parseLong(condition.getMap().get("roleId").toString()));
			digui(td,hasResource); 
		}else {
			digui(td,null);
		}
		return treeList;
	}
	
	private void digui(TreeDto td,List<Resource> hasResource){
		List<TreeDto> treeChildrens = new ArrayList<TreeDto>();
		List<Resource> findResourceChildrens = this.resourceMapper.queryByPid(td.getId());
		if(findResourceChildrens.size() > 0) {
			for(Resource res : findResourceChildrens) {
				TreeDto tdChild = new TreeDto();
				tdChild.setId(res.getId().intValue());
				tdChild.setText(res.getName());
				tdChild.setState(Constant.TREE_STATE_OPEN);
				if(hasResource != null && hasResource.contains(res) /*&& this.resourceService.isLeaf(res)*/) {
					tdChild.setChecked(true);
				}
				treeChildrens.add(tdChild);
				digui(tdChild,hasResource);
			}
			td.setChildren(treeChildrens);
		}
	}
	
	@RequestMapping("/listUI.html")
	public String listUI(){
		return PRIX + "listUI";
	}
	
	
	@RequestMapping("/resourceTree.json")
	@ResponseBody
	public List<TreeDto> resourceTree(Condition condition){
		Map<String,Object> queryParams = condition.getMap();
		if(queryParams.get("id") == null) {
			List<TreeDto> tdList = new ArrayList<TreeDto>();
			TreeDto td = new TreeDto();
			td.setId(0);
			td.setText("系统资源");
			td.setIconCls(ResourceType.getIcon(0));
			td.setState(Constant.TREE_STATE_OPEN);
			List<Resource> findResourceChildrens = this.resourceMapper.queryByPid(td.getId());
			List<TreeDto> treeDtoChildrens = new ArrayList<TreeDto>();
			for(Resource res : findResourceChildrens){
				TreeDto treeDtoChild = new TreeDto();
				treeDtoChild.setId(res.getId().intValue());
				if(res.getCode() != null && ! "".equals(res.getCode().trim())) {
					treeDtoChild.setText(res.getName() + "<span class=\"blue\">[ " + res.getCode() + "]</span>");
				}else {
					treeDtoChild.setText(res.getName());
				}
				if(this.resourceMapper.queryByPid(res.getId().intValue()).size() > 0) {
					treeDtoChild.setState("closed");
				}else {
					treeDtoChild.setState("open");
				}
				treeDtoChild.setIconCls(ResourceType.getIcon(res.getType()));
				treeDtoChildrens.add(treeDtoChild);
			}
			td.setChildren(treeDtoChildrens);
			tdList.add(td);
			return tdList;
		}else {
			List<Resource> findResourceChildrens = this.resourceMapper.queryByPid(Integer.parseInt(queryParams.get("id").toString()));
			List<TreeDto> treeDtoChildrens = new ArrayList<TreeDto>();
			for(Resource res : findResourceChildrens){
				TreeDto treeDtoChild = new TreeDto();
				treeDtoChild.setId(res.getId().intValue());
				if(res.getCode() != null && !"".equals(res.getCode().trim())) {
					treeDtoChild.setText(res.getName() + "<span class=\"blue\">[ " + res.getCode() + "]</span>");
				}else {
					treeDtoChild.setText(res.getName());
				}
				if(this.resourceMapper.queryByPid(res.getId().intValue()).size() > 0) {
					treeDtoChild.setState("closed");
				}else {
					treeDtoChild.setState("open");
				}
				treeDtoChild.setIconCls(ResourceType.getIcon(res.getType()));
				treeDtoChildrens.add(treeDtoChild);
			}
			return treeDtoChildrens;
		}
	}
	
	@RequestMapping("/subres.json")
	@ResponseBody
	public List<Resource> subres(Condition condition) {
		return this.resourceMapper.queryByPid(Integer.valueOf(condition.getMap().get("id").toString()));
	}
	
	@RequestMapping("/save_res.json")
	@ResponseBody
	public Map<String,Object> saveRes(Condition condition) {
		Map<String,Object> map = condition.getMap();
		try {
			Resource resource = TransformationUtil.toObject(map, Resource.class);
			User user = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
			resource.setCreateBy(user.getId());
			resource.setUpdateBy(user.getId());
			this.resourceMapper.insert(resource);
			map.put("success", true);
			map.put("id", resource.getId());
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	@RequestMapping("/update_res.json")
	@ResponseBody
	public Map<String,Object> updateRes(Condition condition) {
		Map<String,Object> map = condition.getMap();
		try {
			Resource resource = TransformationUtil.toObject(map, Resource.class);
			User user = (User)HttpKit.getRequest().getSession().getAttribute(Constant.USER_SESSION_NAME);
			resource.setUpdateBy(user.getId());
			this.resourceMapper.updateById(resource);
			map.put("success", true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	@RequestMapping("/delete_res.json")
	@ResponseBody
	public Wrapper<?> deleteRes(Condition condition) {
		this.resourceService.delete(Long.valueOf(condition.getMap().get("id").toString()));
		return successWrapper();
	}
	
	@RequestMapping("/saveRoleResource.json")
	@ResponseBody
	public Wrapper<?> saveRoleResource(Condition condition){
		try {
			Long roleId = condition.getMap().get("roleId") == null ? null : Long.parseLong(condition.getMap().get("roleId").toString());
			String resIds = condition.getMap().get("resIds") == null ? null : condition.getMap().get("resIds").toString();
			this.roleService.saveRoleResource(roleId, resIds);
			return successWrapper();
		} catch (Exception e) {
			e.printStackTrace();
			return failWrapper();
		}
	}
}
