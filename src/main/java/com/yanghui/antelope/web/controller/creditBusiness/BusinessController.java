package com.yanghui.antelope.web.controller.creditBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanghui.antelope.common.constant.CustomerTypeEnum;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.ProfessionMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Profession;
/**
 * 自雇资料
 * @author think
 *
 */
@Controller
@RequestMapping("/business")
public class BusinessController {
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private ProfessionMapper professionMapper;
	
	@RequestMapping("/businessUI.html")
	public String businessUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId){
		if(customerId != null) {
			Customer find  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", find);
		}
		return PRIX + "businessUI";
	}
	
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		if(customerId == null) {
			return "redirect:/customerInput/indexUI.html";
		}
		Customer find  = this.customerMapper.selectById(customerId);
		if(find.getType().intValue() == CustomerTypeEnum.WORKANDBOSS.getType()) {
			Profession findP = this.professionMapper.getByCustomerId(customerId);
			String params = "?customerId=" + customerId;
			if(findP != null) {
				params = params + "&professionId=" + findP.getId();
			}
			return "redirect:/profession/professionUI.html" + params;
		}else {
			return "redirect:/customerInput/indexUI.html?customerId=" + customerId;
		}
	}
}
