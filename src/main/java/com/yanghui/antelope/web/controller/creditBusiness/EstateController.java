package com.yanghui.antelope.web.controller.creditBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.web.controller.common.BaseComtroller;

@Controller
@RequestMapping("/estate")
public class EstateController extends BaseComtroller{
	
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@RequestMapping("/estateUI.html")
	public String estateUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId) {
		if(customerId != null) {
			Customer findC  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", findC);
		}
		return PRIX + "estateUI";
	}
}
