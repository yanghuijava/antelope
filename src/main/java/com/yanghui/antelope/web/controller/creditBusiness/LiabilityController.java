package com.yanghui.antelope.web.controller.creditBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.LiabilityMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Liability;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.Wrapper;

/**
 * <p>
 * 负债
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-26
 */
@Controller
@RequestMapping("/liability")
public class LiabilityController extends BaseComtroller{
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private LiabilityMapper liabilityMapper;
	@Autowired
	private CustomerMapper customerMapper;
	
	/**
	 * 职业页面
	 * @param model
	 * @param customerId
	 * @param liabilityId
	 * @return
	 */
	@RequestMapping("/liabilityUI.html")
	public String liabilityUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId,
			@RequestParam(value="liabilityId",required=false)Long liabilityId) {
		if(customerId != null) {
			Customer findC  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", findC);
			if(liabilityId != null) {
				Liability findL = this.liabilityMapper.selectById(liabilityId);
				model.addAttribute("liability", findL);
			}else {
				Liability findL = this.liabilityMapper.getByCustomerId(findC.getId());
				model.addAttribute("liability", findL);
			}
		}
		return PRIX + "liabilityUI";
	}
	
	@RequestMapping("/load.json")
	@ResponseBody
	public Liability load(Condition condition){
		Liability l = this.liabilityMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		return l;
	}
	
	@RequestMapping("/save.json")
	@ResponseBody
	public Wrapper<String> save(Condition condition) throws Exception{
		Liability liability = super.saveGet(condition.getMap(), Liability.class);
		if(liability.getCustomerId() == null) {
			throw new BusinessExcption("没有客户信息，无法保存职业信息！");
		}
		this.liabilityMapper.insert(liability);
		return successWrapper().setData(liability.getCustomerId().toString());
	}

	@RequestMapping("/update.json")
	@ResponseBody
	public Wrapper<String> update(Condition condition) throws Exception{
		Liability liability = super.updateGet(condition.getMap(), Liability.class);
		if(liability.getId() == null) {
			throw new BusinessExcption("职业信息不存在，无法更新！");
		}
		this.liabilityMapper.updateById(liability);
		return successWrapper().setData(liability.getCustomerId().toString());
	}
	/**
	 * 上一页面：车辆资料（负债------>车辆）
	 * @param customerId
	 * @param request
	 * @return
	 */
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		return "redirect:/vehicle/vehicleUI.html?customerId=" + customerId;
	}
	/**
	 * 下一个页面：客户需求（负债------>客户需求）
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/nextUI.html")
	public String nextUI(Model model,@RequestParam(value="customerId")Long customerId) {
		return "redirect:/demand/demandUI.html?customerId=" + customerId;
	}
}
