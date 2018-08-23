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
import com.yanghui.antelope.dao.creditBusiness.EstateMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Estate;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.EstateVO;
import com.yanghui.antelope.web.vo.PageResult;
import com.yanghui.antelope.web.vo.Wrapper;
import com.yanghui.antelope.web.wrapper.CommonWrapper;

@Controller
@RequestMapping("/estate")
public class EstateController extends BaseComtroller{
	
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private EstateMapper estateMapper;
	
	@RequestMapping("/estateUI.html")
	public String estateUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId) {
		if(customerId != null) {
			Customer findC  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", findC);
		}
		return PRIX + "estateUI";
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResult<EstateVO> list(Condition condition) throws Exception{
		List<Estate> data = this.estateMapper.getPage(condition.getPagination(),condition.getMap());
		return CommonWrapper.createEstatePage(condition.getPagination(), data);
	}
	
	@RequestMapping("/load.json")
	@ResponseBody
	public EstateVO load(Condition condition){
		Estate e = this.estateMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		EstateVO ev = new EstateVO();
		BeanUtils.copyProperties(e, ev);
		return ev;
	}
	
	@RequestMapping("/save.json")
	@ResponseBody
	public Wrapper<String> save(Condition condition) throws Exception{
		Estate estate = super.saveGet(condition.getMap(), Estate.class);
		if(estate.getCustomerId() == null) {
			throw new BusinessExcption("没有客户信息，无法保存企业信息！");
		}
		this.estateMapper.insert(estate);
		return successWrapper().setData(estate.getCustomerId().toString());
	}
	
	@RequestMapping("/update.json")
	@ResponseBody
	public Wrapper<String> update(Condition condition) throws Exception{
		Estate estate = super.updateGet(condition.getMap(), Estate.class);
		this.estateMapper.updateById(estate);
		return successWrapper().setData(estate.getCustomerId().toString());
	}
	
	@RequestMapping("/delete.json")
	@ResponseBody
	public Wrapper<?> delete(@RequestParam("id") Long id){
		this.estateMapper.deleteById(id);
		return successWrapper();
	}
	
	/**
	 * 上一个页面：企业资料（房产资料------>企业资料）
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		return "redirect:/business/businessUI.html?customerId=" + customerId;
	}
}
