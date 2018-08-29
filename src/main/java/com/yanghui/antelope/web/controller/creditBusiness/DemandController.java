package com.yanghui.antelope.web.controller.creditBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.DemandMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Demand;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.Wrapper;

/**
 * <p>
 * 客户需求资料 前端控制器
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-26
 */
@Controller
@RequestMapping("/demand")
public class DemandController extends BaseComtroller{
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private DemandMapper demandMapper;
	@Autowired
	private CustomerMapper customerMapper;
	
	/**
	 * 客户需求
	 * @param model
	 * @param customerId
	 * @param professionId
	 * @return
	 */
	@RequestMapping("/demandUI.html")
	public String professionUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId,
			@RequestParam(value="professionId",required=false)Long professionId) {
		if(customerId != null) {
			Customer findC  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", findC);
			if(professionId != null) {
				Demand demand = this.demandMapper.selectById(professionId);
				model.addAttribute("demand", demand);
			}else {
				Demand demand = this.demandMapper.getByCustomerId(findC.getId());
				model.addAttribute("demand", demand);
			}
		}
		return PRIX + "demandUI";
	}
	
	@RequestMapping("/load.json")
	@ResponseBody
	public Demand load(Condition condition){
		Demand demand = this.demandMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		return demand;
	}
	
	@RequestMapping("/save.json")
	@ResponseBody
	public Wrapper<String> save(Condition condition) throws Exception{
		Demand demand = super.saveGet(condition.getMap(), Demand.class);
		if(demand.getCustomerId() == null) {
			throw new BusinessExcption("没有客户信息，无法保存客户需求信息！");
		}
		this.demandMapper.insert(demand);
		return successWrapper().setData(demand.getCustomerId().toString());
	}

	@RequestMapping("/update.json")
	@ResponseBody
	public Wrapper<String> update(Condition condition) throws Exception{
		Demand demand = super.updateGet(condition.getMap(), Demand.class);
		if(demand.getId() == null) {
			throw new BusinessExcption("客户需求信息不存在，无法更新！");
		}
		this.demandMapper.updateById(demand);
		return successWrapper().setData(demand.getCustomerId().toString());
	}
	/**
	 * 上一页面：负债（客户需求------>负债）
	 * @param customerId
	 * @param request
	 * @return
	 */
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		return "redirect:/liability/liabilityUI.html?customerId=" + customerId;
	}
	/**
	 * 下一个页面：方案页面（客户需求------>方案）
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/nextUI.html")
	public String nextUI(Model model,@RequestParam(value="customerId")Long customerId) {
		return "redirect:/programme/programmeUI.html?customerId=" + customerId;
	}
}
