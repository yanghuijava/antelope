package com.yanghui.antelope.web.controller.creditBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yanghui.antelope.common.constant.CustomerTypeEnum;
import com.yanghui.antelope.common.exception.BusinessExcption;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.ProfessionMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Profession;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.Condition;
import com.yanghui.antelope.web.vo.Wrapper;

/**
 * <p>
 * 客户职业资料 前端控制器
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-26
 */
@Controller
@RequestMapping("/profession")
public class ProfessionController extends BaseComtroller{
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private ProfessionMapper professionMapper;
	@Autowired
	private CustomerMapper customerMapper;
	
	/**
	 * 职业页面
	 * @param model
	 * @param customerId
	 * @param professionId
	 * @return
	 */
	@RequestMapping("/professionUI.html")
	public String professionUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId,
			@RequestParam(value="professionId",required=false)Long professionId) {
		if(customerId != null) {
			Customer findC  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", findC);
			if(professionId != null) {
				Profession findP = this.professionMapper.selectById(professionId);
				model.addAttribute("profession", findP);
			}else {
				Profession findP = this.professionMapper.getByCustomerId(findC.getId());
				model.addAttribute("profession", findP);
			}
		}
		return PRIX + "professionUI";
	}
	
	@RequestMapping("/load.json")
	@ResponseBody
	public Profession load(Condition condition){
		Profession p = this.professionMapper.selectById(Long.valueOf(condition.getMap().get("id").toString()));
		return p;
	}
	
	/**
	 * 保存职业资料
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save.json")
	@ResponseBody
	public Wrapper<String> save(Condition condition) throws Exception{
		Profession profession = super.saveGet(condition.getMap(), Profession.class);
		if(profession.getCustomerId() == null) {
			throw new BusinessExcption("没有客户信息，无法保存职业信息！");
		}
		this.professionMapper.insert(profession);
		return successWrapper().setData(profession.getCustomerId().toString());
	}
	/**
	 * 更新职业资料
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update.json")
	@ResponseBody
	public Wrapper<String> update(Condition condition) throws Exception{
		Profession profession = super.updateGet(condition.getMap(), Profession.class);
		if(profession.getId() == null) {
			throw new BusinessExcption("职业信息不存在，无法更新！");
		}
		this.professionMapper.updateById(profession);
		return successWrapper().setData(profession.getCustomerId().toString());
	}
	/**
	 * 上一页面：跳转到客户资料页面
	 * @param customerId
	 * @param request
	 * @return
	 */
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		return "redirect:/customerInput/indexUI.html?customerId=" + customerId;
	}
	/**
	 * 下一个页面：自雇或者同行贷
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/nextUI.html")
	public String nextUI(Model model,@RequestParam(value="customerId")Long customerId) {
		Customer find  = this.customerMapper.selectById(customerId);
		model.addAttribute("customer", find);
		if(find.getType().intValue() == CustomerTypeEnum.WORKANDBOSS.getType()) {
			return "redirect:/business/businessUI.html?customerId=" + customerId;
		}else {
			return "redirect:/peerLoan/peerLoanUI.html?customerId=" + customerId;
		}
	}
}
