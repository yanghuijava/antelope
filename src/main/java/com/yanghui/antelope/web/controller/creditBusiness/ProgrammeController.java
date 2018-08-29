package com.yanghui.antelope.web.controller.creditBusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.ProgrammeMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.web.controller.common.BaseComtroller;

/**
 * <p>
 * 客户职业资料 前端控制器
 * </p>
 *
 * @author 杨辉
 * @since 2017-06-26
 */
@Controller
@RequestMapping("/programme")
public class ProgrammeController extends BaseComtroller{
	private static final String PRIX = "creditBusiness/customerInput/";
	
	@Autowired
	private ProgrammeMapper programmeMapper;
	@Autowired
	private CustomerMapper customerMapper;
	
	@RequestMapping("/programmeUI.html")
	public String programmeUI(Model model,
			@RequestParam(value="customerId",required=false)Long customerId) {
		if(customerId != null) {
			Customer findC  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", findC);
		}
		return PRIX + "programmeUI";
	}
	
	/**
	 * 上一页面：跳转到客户资料页面
	 * @param customerId
	 * @param request
	 * @return
	 */
	@RequestMapping("/lastPageUI.html")
	public String lastPageUI(@RequestParam(value="customerId",required=false)Long customerId) {
		return "redirect:/demand/demandUI.html?customerId=" + customerId;
	}
}
