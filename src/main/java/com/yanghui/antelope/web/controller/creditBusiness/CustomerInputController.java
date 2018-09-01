package com.yanghui.antelope.web.controller.creditBusiness;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanghui.antelope.common.constant.CustomerStatusEnum;
import com.yanghui.antelope.common.constant.CustomerTypeEnum;
import com.yanghui.antelope.common.constant.MarriageStatusEnum;
import com.yanghui.antelope.common.constant.WageModelEnum;
import com.yanghui.antelope.dao.creditBusiness.BusinessMapper;
import com.yanghui.antelope.dao.creditBusiness.CustomerMapper;
import com.yanghui.antelope.dao.creditBusiness.DemandMapper;
import com.yanghui.antelope.dao.creditBusiness.EstateMapper;
import com.yanghui.antelope.dao.creditBusiness.LiabilityMapper;
import com.yanghui.antelope.dao.creditBusiness.PolicyMapper;
import com.yanghui.antelope.dao.creditBusiness.ProfessionMapper;
import com.yanghui.antelope.dao.creditBusiness.ProgrammeMapper;
import com.yanghui.antelope.dao.creditBusiness.VehicleMapper;
import com.yanghui.antelope.dao.system.UserMapper;
import com.yanghui.antelope.domain.creditBusiness.Customer;
import com.yanghui.antelope.domain.creditBusiness.Demand;
import com.yanghui.antelope.domain.creditBusiness.Liability;
import com.yanghui.antelope.domain.creditBusiness.Profession;
import com.yanghui.antelope.domain.creditBusiness.Programme;
import com.yanghui.antelope.web.controller.common.BaseComtroller;
import com.yanghui.antelope.web.vo.CustomerVO;
import com.yanghui.antelope.web.vo.ProfessionVO;
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
	private BusinessMapper businessMapper;
	@Autowired
	private ProfessionMapper professionMapper;
	@Autowired
	private DemandMapper demandMapper;
	@Autowired
	private EstateMapper estateMapper;
	@Autowired
	private LiabilityMapper liabilityMapper;
	@Autowired
	private PolicyMapper policyMapper;
	@Autowired
	private ProgrammeMapper programmeMapper;
	@Autowired
	private VehicleMapper vehicleMapper;
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
	 * 下一个页面：职业资料页面（客户资料页面------>职业资料页面）
	 * @param model
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/nextUI.html")
	public String nextUI(@RequestParam("customerId")Long customerId){
		return "redirect:/profession/professionUI.html?customerId=" + customerId;
	}
	
	@RequestMapping("/customerDetailsUI.html")
	public String customerDetailsUI(Model model,@RequestParam(value="customerId")Long customerId,
			@RequestParam(value="from",required=false)String from) {
		//客户资料
		Customer find  = this.customerMapper.selectById(customerId);
		CustomerVO cv = new CustomerVO();
		BeanUtils.copyProperties(find, cv);
		cv.setAccountManagerName(userMapper.selectById(find.getAccountManager()).getName());
		cv.setMarriageStatusName(MarriageStatusEnum.get(find.getMarriageStatus()).getName());
		cv.setTypeName(CustomerTypeEnum.get(find.getType()).getName());
		cv.setStatusName(CustomerStatusEnum.getStatus(find.getStatus()).getName());
		model.addAttribute("customer", cv);
		if(!StringUtils.isEmpty(from)) {
			model.addAttribute("from", from);
		}
		
		//职业资料
		Profession profession = this.professionMapper.getByCustomerId(customerId);
		ProfessionVO pv = new ProfessionVO();
		pv.setWageModelName(WageModelEnum.getModel(profession.getWageModel()).getName());
		BeanUtils.copyProperties(profession, pv);
		model.addAttribute("profession", pv);
		
		//负债资料
		Liability liability = this.liabilityMapper.getByCustomerId(customerId);
		model.addAttribute("liability", liability);
		
		//客户需求
		Demand demand = this.demandMapper.getByCustomerId(customerId);
		model.addAttribute("demand", demand);
		
		//客户方案
		Programme programme = this.programmeMapper.getByCustomerId(customerId);
		model.addAttribute("programme", programme);
		return PRIX + "customerDetailsUI";
	}
}
