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
import com.yanghui.antelope.dao.creditBusiness.BusinessMapper;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.ProfessionMapper;
import com.yanghui.antelope.domain.creditBusiness.Business;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Profession;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.BusinessVO;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.PageResult;
import com.yanghui.antelope.web.vo.Wrapper;
import com.yanghui.antelope.web.wrapper.CommonWrapper;
/**
 * 企业资料
 * @author think
 *
 */
@Controller
@RequestMapping("/business")
public class BusinessController extends BaseComtroller{
	
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private ProfessionMapper professionMapper;
	@Autowired
	private BusinessMapper businessMapper;
	
	@RequestMapping("/businessUI.html")
	public String businessUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId){
		if(customerId != null) {
			Customer find  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", find);
		}
		return PRIX + "businessUI";
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResult<BusinessVO> list(Condition condition) throws Exception{
		List<Business> data = this.businessMapper.getPage(condition.getPagination(),condition.getMap());
		return CommonWrapper.createBusinessPage(condition.getPagination(), data);
	}
	
	@RequestMapping("/load.json")
	@ResponseBody
	public BusinessVO load(Condition condition){
		Business b = this.businessMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		BusinessVO bv = new BusinessVO();
		BeanUtils.copyProperties(b, bv);
		return bv;
	}
	
	@RequestMapping("/save.json")
	@ResponseBody
	public Wrapper<String> save(Condition condition) throws Exception{
		Business business = super.saveGet(condition.getMap(), Business.class);
		if(business.getCustomerId() == null) {
			throw new BusinessExcption("没有客户信息，无法保存企业信息！");
		}
		this.businessMapper.insert(business);
		return successWrapper().setData(business.getCustomerId().toString());
	}
	
	@RequestMapping("/update.json")
	@ResponseBody
	public Wrapper<String> update(Condition condition) throws Exception{
		Business business = super.updateGet(condition.getMap(), Business.class);
		this.businessMapper.updateById(business);
		return successWrapper().setData(business.getCustomerId().toString());
	}
	
	@RequestMapping("/delete.json")
	@ResponseBody
	public Wrapper<?> delete(@RequestParam("id") Long id){
		this.businessMapper.deleteById(id);
		return successWrapper();
	}
	
	/**
	 * 下一个页面：房产资料（企业资料------>房产资料）
	 * @param model
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/nextUI.html")
	public String nextUI(Model model,@RequestParam(value="customerId")Long customerId) {
		return "redirect:/estate/estateUI.html?customerId=" + customerId;
	}
	
	/**
	 * 上一个页面：职业资料（企业资料------>职业资料）
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		Profession findP = this.professionMapper.getByCustomerId(customerId);
		String params = "?customerId=" + customerId;
		if(findP != null) {
			params = params + "&professionId=" + findP.getId();
		}
		return "redirect:/profession/professionUI.html" + params;
	}
}
