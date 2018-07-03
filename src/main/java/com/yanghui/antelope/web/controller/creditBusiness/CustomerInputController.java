package com.yanghui.antelope.web.controller.creditBusiness;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.yanghui.antelope.common.constant.CustomerTypeEnum;
import com.yanghui.antelope.common.constant.MarriageStatusEnum;
import com.yanghui.antelope.common.utils.DateUtil;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.system.UserMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.CustomerVO;
/**
 * 客户资料录入
 * @author think
 *
 */
@Controller
@RequestMapping("/customerInput")
public class CustomerInputController extends BaseComtroller{
	
	private static final String PRIX = "creditBusiness/customerInput/";
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private UserMapper userMapper;
	/**
	 * 录入首页
	 * @param model
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/indexUI.html")
	public String customerInputUI(Model model,@RequestParam(value="customerId",required=false)Long customerId){
		if(customerId != null){
			Customer find  = this.customerMapper.selectById(customerId);
			model.addAttribute("customer", find);
		}
		return PRIX + "inputIndexUI";
	}
	/**
	 * 下一个页面：职业资料页面或者自雇页面
	 * @param model
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/nextUI.html")
	public String nextUI(@RequestParam("customerId")Long customerId){
		Customer find  = this.customerMapper.selectById(customerId);
		if(find.getType().intValue() == CustomerTypeEnum.WORK.getType()){
			return "redirect:/profession/professionUI.html?customerId=" + customerId;
		}else if(find.getType().intValue() == CustomerTypeEnum.BOSS.getType()){
			return "redirect:/business/businessUI.html?customerId=" + customerId;
		}
		return "redirect:/profession/professionUI.html?customerId=" + customerId;
	}
	
	@RequestMapping("/customerDetailsUI.html")
	public String customerDetailsUI(Model model,@RequestParam(value="customerId")Long customerId,
			@RequestParam(value="from",required=false)String from) {
		Customer find  = this.customerMapper.selectById(customerId);
		CustomerVO cv = new CustomerVO();
		BeanUtils.copyProperties(find, cv);
		cv.setAccountManagerName(userMapper.selectById(find.getAccountManager()).getName());
		cv.setMarriageStatusName(MarriageStatusEnum.get(find.getMarriageStatus()).getName());
		cv.setTypeName(CustomerTypeEnum.get(find.getType()).getName());
		cv.setComeShenzhenDateStr(DateUtil.format(find.getComeShenzhenDate(), "yyyy-MM-dd"));
		model.addAttribute("customer", cv);
		if(!StringUtils.isEmpty(from)) {
			model.addAttribute("from", from);
		}
		return PRIX + "customerDetailsUI";
	}
}
