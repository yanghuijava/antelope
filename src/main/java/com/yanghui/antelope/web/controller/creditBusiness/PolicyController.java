package com.yanghui.antelope.web.controller.creditBusiness;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.PolicyMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Policy;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.PageResult;
import com.yanghui.antelope.web.vo.PolicyVO;
import com.yanghui.antelope.web.vo.Wrapper;
import com.yanghui.antelope.web.wrapper.CommonWrapper;

@Controller
@RequestMapping("/policy")
public class PolicyController extends BaseComtroller{
	
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private PolicyMapper policyMapper;
	
	@RequestMapping("/policyUI.html")
	public String policyUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId) {
		if(customerId != null) {
			Customer findC  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", findC);
		}
		return PRIX + "policyUI";
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResult<PolicyVO> list(Condition condition) throws Exception{
		List<Policy> data = this.policyMapper.getPage(condition.getPagination(),condition.getMap());
		return CommonWrapper.createPolicyPage(condition.getPagination(), data);
	}
	
	@RequestMapping("/load.json")
	@ResponseBody
	public PolicyVO load(Condition condition){
		Policy p = this.policyMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		PolicyVO pv = new PolicyVO();
		BeanUtils.copyProperties(p, pv);
		return pv;
	}
	
	@RequestMapping("/save.json")
	@ResponseBody
	public Wrapper<String> save(Condition condition) throws Exception{
		Policy policy = super.saveGet(condition.getMap(), Policy.class);
		if(policy.getCustomerId() == null) {
			throw new BusinessExcption("没有客户信息，无法保存企业信息！");
		}
		this.policyMapper.insert(policy);
		return successWrapper().setData(policy.getCustomerId().toString());
	}
	
	@RequestMapping("/update.json")
	@ResponseBody
	public Wrapper<String> update(Condition condition) throws Exception{
		Policy policy = super.updateGet(condition.getMap(), Policy.class);
		this.policyMapper.updateById(policy);
		return successWrapper().setData(policy.getCustomerId().toString());
	}
	
	@RequestMapping("/delete.json")
	@ResponseBody
	public Wrapper<?> delete(@RequestParam("id") Long id){
		this.policyMapper.deleteById(id);
		return successWrapper();
	}
	
	/**
	 * 上一个页面：房产资料（保单资料------>房产资料）
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		return "redirect:/estate/estateUI.html?customerId=" + customerId;
	}
}
